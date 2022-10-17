package br.com.example.backendAgency.demo.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	@Column(name="cpf")
	private String cpf;
	@Column(name="email")
	private String email;
	@Column (name="endereco")
	private String endereco;
	@Column(name="cidade")
	private String cidade;
	@Column(name="uf")
	private String uf;
	@Column(name="cep")
	private String cep;
	
	public Cliente() {
		
	}
	
	public Cliente(long id, String nome, String cpf, String email, String endereco, String cidade,
			String uf, String cep) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

}
