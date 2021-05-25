package projetos.AppRondas_Grupo04.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Locomocao
 *
 */
@Entity

public class Locomocao implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LocomocaoId")
	@SequenceGenerator(name = "LocomocaoId", sequenceName = "LocomocaoId", allocationSize = 1)	
	private Integer id;
	
	@Column(length = 40, nullable = false)
	private String descricao;
	
	@Column(length = 10)
	private String placa;
	
	private static final long serialVersionUID = 1L;

	public Locomocao() {
		super();
	}   
	public Locomocao(Integer id, String descricao, String placa) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.placa = placa;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
   
}
