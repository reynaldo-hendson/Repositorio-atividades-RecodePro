package controller;


import excecao.ResourceNotFoundException;
import modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repo.PedidoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    //Search all request
    @GetMapping("/lista")
    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
    }

    //Search request for Id.
    @GetMapping("/listar/{id}")
    private ResponseEntity<Pedido> getPedidoById(@PathVariable Long id){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pedido não existe"+id));
        return ResponseEntity.ok(pedido);
    }

    //Create new request
    @PostMapping("/cadastrar")
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    //Alter request
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedidoDetails) {
       Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido nao existe com id :" + id));

        pedido.setIdCliente(pedidoDetails.getIdCliente());
        pedido.setDataPedido(pedidoDetails.getDataPedido());
        pedido.setDataViagem(pedidoDetails.getDataViagem());

        Pedido updatedPedido = pedidoRepository.save(pedido);
        return ResponseEntity.ok(updatedPedido);
    }

    //Delete request
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePedido (@PathVariable Long id) {
        Pedido pedido= pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido nao existe com id :" + id));
        pedidoRepository.delete(pedido);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
