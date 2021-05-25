package projetos.AppRondas_Grupo04.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity 
public class Pessoa implements Serializable { 
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PessoaId")
	@SequenceGenerator(name = "PessoaId", sequenceName = "PessoaId", allocationSize = 1)
	private Integer id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	
	@Column(length = 100, nullable = false, unique = true)
	private String loginApp;
	
	@Column(length = 64, nullable = false)
	private String senha;
	private static final long serialVersionUID = 1L;
	
	// 1) Um contrutor sem argumentos (gerar com botão direito > source > Generate constructor)
	public Pessoa() {
	}
	
	public Pessoa(Integer id) {
		super();
		this.id = id;
	}

	public Pessoa(Integer id, String nome, String loginApp, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.loginApp = loginApp;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLoginApp() {
		return loginApp;
	}

	public void setLoginApp(String loginApp) {
		this.loginApp = loginApp;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
