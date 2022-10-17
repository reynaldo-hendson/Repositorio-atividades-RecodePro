package br.com.example.backendAgency.demo.controller;


import br.com.example.backendAgency.demo.excecao.ResourceNotFoundException;
import br.com.example.backendAgency.demo.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.example.backendAgency.demo.repo.ClienteRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    //Search all Clients
    @GetMapping("/lista")
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    //Search client for Id.
    @GetMapping("/listar/{id}")
    private ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cliente não existe"+id));
        return ResponseEntity.ok(cliente);
    }

    //Create new client
    @PostMapping("/cadastrar")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //Alter Client
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente nao existe com id :" + id));

        cliente.setNome(clienteDetails.getNome());
        cliente.setCpf(clienteDetails.getCpf());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setEndereco(clienteDetails.getEndereco());
        cliente.setCidade(clienteDetails.getCidade());
        cliente.setUf(clienteDetails.getUf());
        cliente.setCep(clienteDetails.getCep());

        Cliente updatedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    //Delete Client
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCliente (@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente nao existe com id :" + id));
        clienteRepository.delete(cliente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
