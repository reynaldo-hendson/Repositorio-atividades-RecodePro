package controller;


import exception.ResourceNotFoundException;
import model.Cliente;
import model.ItensPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.ItensPedidoRepository;

import javax.persistence.Table;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/api/v1/itensPedido")
public class ItensPedidoController {

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    //Search all items
    @GetMapping("/itensPedidos")
    public List<ItensPedido> getAllItensPedidos(){
        return itensPedidoRepository.findAll();
    }

    //Search items for Id.
    @GetMapping("/itensPedidos/{id}")
    private ResponseEntity<ItensPedido> getItensPedidoById(@PathVariable Long id){
        ItensPedido itensPedido= itensPedidoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Itens não encontrado"+id));
        return ResponseEntity.ok(itensPedido);
    }

    //Create new items
    @PostMapping("/itensPedidos")
    public ItensPedido createItensPedido(@RequestBody ItensPedido itensPedido) {
        return itensPedidoRepository.save(itensPedido);
    }

    //Alter items
    @PutMapping("/itensPedidos/{id}")
    public ResponseEntity<ItensPedido> updateItensPedido(@PathVariable Long id, @RequestBody ItensPedido itensPedidoDetails) {
        ItensPedido itensPedido= itensPedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Itens nao existem com id :" + id));

        itensPedido.setIdPedido(itensPedidoDetails.getIdPedido());
        itensPedido.setQuantidade(itensPedidoDetails.getQuantidade());
        itensPedido.setIdProduto(itensPedidoDetails.getIdProduto());

        ItensPedido updatedItensPedido = itensPedidoRepository.save(itensPedido);
        return ResponseEntity.ok(updatedItensPedido);
    }

    //Delete items
    @DeleteMapping("/itensPedidos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteItensPedido (@PathVariable Long id) {
        ItensPedido itensPedido = itensPedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Itens nao existem com id :" + id));
        itensPedidoRepository.delete(itensPedido);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
