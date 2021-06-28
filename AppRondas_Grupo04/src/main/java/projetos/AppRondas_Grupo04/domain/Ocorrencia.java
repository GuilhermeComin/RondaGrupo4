package projetos.AppRondas_Grupo04.domain;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.Base64;
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
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataHora;
	
	@Column(length = 30, nullable = false)
	private String titulo;
	
	@Column(length = 200, nullable = false)
	private String descricao;
	
	@Column(length = 40, nullable = false)
	private Long lat;
	
	@Column(length = 40, nullable = false)
	private Long lon;
	
	@Lob
	private byte[] foto;
	
	@ManyToOne(optional =  false)
	private Ronda ronda;
	private static final long serialVersionUID = 1L;

	public Ocorrencia() {
		super();
	}   
	

	public Ocorrencia(Integer id, Date dataHora, String titulo, String descricao, Long lat, Long lon,
			Ronda ronda) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.titulo = titulo;
		this.descricao = descricao;
		this.lat = lat;
		this.lon = lon;
		this.ronda = ronda;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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
	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public String getFotoBase64() {
		if (foto != null)
			return new String(Base64.getEncoder().encode(foto));
		else 
			return "";
	}

	public Ronda getRonda() {
		return ronda;
	}

	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}
    
}
