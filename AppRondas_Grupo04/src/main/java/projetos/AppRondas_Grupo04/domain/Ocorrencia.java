package projetos.AppRondas_Grupo04.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ocorrencia
 *
 */
@Entity

public class Ocorrencia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OcorrenciaId")
	@SequenceGenerator(name = "OcorrenciaId", sequenceName = "OcorrenciaId", allocationSize = 1)	
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataHora;
	
	@Column(length = 30, nullable = false)
	private String titulo;
	
	@Column(length = 200, nullable = false)
	private String descricao;
	
	@Column(length = 40)
	private Long lat;
	
	@Column(length = 40)
	private Long lon;
	
	@Column(length = 100)
	private String foto;
	
	@ManyToOne
	private Ronda ronda;
	private static final long serialVersionUID = 1L;

	public Ocorrencia() {
		super();
	}   

	public Ocorrencia(Long id, Date dataHora, String titulo, String descricao, Long lat, Long lon, String foto,
			Ronda ronda) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.titulo = titulo;
		this.descricao = descricao;
		this.lat = lat;
		this.lon = lon;
		this.foto = foto;
		this.ronda = ronda;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Date getDataHora() {
		return this.dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}   
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public Long getLat() {
		return this.lat;
	}

	public void setLat(Long lat) {
		this.lat = lat;
	}   
	public Long getLon() {
		return this.lon;
	}

	public void setLon(Long lon) {
		this.lon = lon;
	}   
	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Ronda getRonda() {
		return ronda;
	}

	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}
    
}
