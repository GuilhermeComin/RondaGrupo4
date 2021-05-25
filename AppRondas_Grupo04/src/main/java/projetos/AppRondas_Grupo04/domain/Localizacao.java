package projetos.AppRondas_Grupo04.domain;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Localizacao
 *
 */
@Entity
public class Localizacao implements Serializable {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LocalizacaoId")
	@SequenceGenerator(name = "LocalizacaoId", sequenceName = "LocalizacaoId", allocationSize = 1)	
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 40)
	private Date dataHora;
	
	@Column(length = 40)
	private Float lat;
	
	@Column(length = 40)
	private Float lon;
	
	@ManyToOne
	private Ronda ronda;
	private static final long serialVersionUID = 1L;

	public Localizacao() {
		super();
	}  
	public Localizacao(Long id, Date dataHora, Float lat, Float lon, Ronda ronda) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.lat = lat;
		this.lon = lon;
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
	public Float getLat() {
		return this.lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}   
	public Float getLon() {
		return this.lon;
	}
	public void setLon(Float lon) {
		this.lon = lon;
	}
	public Ronda getRonda() {
		return ronda;
	}
	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}
	
}
