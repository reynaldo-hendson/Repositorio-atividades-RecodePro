package br.com.example.backendAgency.demo.repo;

import br.com.example.backendAgency.demo.modelo.ItensPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long> {

}
