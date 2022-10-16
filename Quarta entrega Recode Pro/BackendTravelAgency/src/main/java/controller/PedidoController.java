package controller;


import exception.ResourceNotFoundException;
import model.Cliente;
import model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.PedidoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    //Search all request
    @GetMapping("/pedidos")
    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
    }

    //Search request for Id.
    @GetMapping("/pedidos/{id}")
    private ResponseEntity<Pedido> getPedidoById(@PathVariable Long id){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pedido não existe"+id));
        return ResponseEntity.ok(pedido);
    }

    //Create new request
    @PostMapping("/pedidos")
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    //Alter request
    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedidoDetails) {
       Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido nao existe com id :" + id));

        pedido.setIdCliente(pedidoDetails.getIdCliente());
        pedido.setDataPedido(pedidoDetails.getDataPedido());
        pedido.setDataViagem(pedidoDetails.getDataViagem());

        Pedido updatedPedido = pedidoRepository.save(pedido);
        return ResponseEntity.ok(updatedPedido);
    }

    //Delete request
    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePedido (@PathVariable Long id) {
        Pedido pedido= pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido nao existe com id :" + id));
        pedidoRepository.delete(pedido);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
