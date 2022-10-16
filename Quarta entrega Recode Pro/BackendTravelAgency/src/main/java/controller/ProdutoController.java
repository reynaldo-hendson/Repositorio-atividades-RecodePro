package controller;

import exception.ResourceNotFoundException;
import model.Cliente;
import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.ProdutoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    //Search all Products
    @GetMapping("/produtos")
    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    //Search client for Id.
    @GetMapping("/produtos/{id}")
    private ResponseEntity<Produto> getProdutoById(@PathVariable Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Produto não existe"+id));
        return ResponseEntity.ok(produto);
    }

    //Create new product
    @PostMapping("/produtos")
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    //Alter Product
    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        Produto produto= produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto nao existe com id :" + id));

        produto.setDescricao(produtoDetails.getDescricao());
        produto.setValor(produtoDetails.getValor());

        Produto updatedProduto = produtoRepository.save(produto);
        return ResponseEntity.ok(updatedProduto);
    }

    //Delete Product
    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduto (@PathVariable Long id) {
        Produto produto= produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto nao existe com id :" + id));
        produtoRepository.delete(produto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
