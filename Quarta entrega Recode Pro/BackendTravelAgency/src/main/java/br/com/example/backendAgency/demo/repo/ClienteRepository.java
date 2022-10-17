package br.com.example.backendAgency.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.example.backendAgency.demo.modelo.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
