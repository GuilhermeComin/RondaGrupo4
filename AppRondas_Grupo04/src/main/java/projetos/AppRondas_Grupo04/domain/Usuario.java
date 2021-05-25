package projetos.AppRondas_Grupo04.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario implements Serializable {   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioId")
	@SequenceGenerator(name = "UsuarioId", sequenceName = "UsuarioId", allocationSize = 1)
	private Integer id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(length = 64, nullable = false)
	private String senha;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public Usuario(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
