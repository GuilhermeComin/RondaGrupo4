package projetos.AppRondas_Grupo04.domain;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ronda
 *
 */
@Entity

public class Ronda implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RondaId")
	@SequenceGenerator(name = "RondaId", sequenceName = "RondaId", allocationSize = 1)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataHoraInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date dataHoraFim;
	
	@Column(nullable = false)
	private Float latUltima;
	
	@Column(nullable = true)
	private Float lonUltima;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraUltima;
	
	@ManyToOne(optional = false)
	private Locomocao locomocao;
	
	@ManyToMany
	private List<Pessoa> vigilantes;
	
	private static final long serialVersionUID = 1L;
	
	public Ronda(Long id, Date dataHoraInicio, Date dataHoraFim, Float latUltima, Float lonUltima, Date dataHoraUltima,
			Locomocao locomocao, List<Pessoa> vigilantes) {
		super();
		this.id = id;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.latUltima = latUltima;
		this.lonUltima = lonUltima;
		this.dataHoraUltima = dataHoraUltima;
		this.locomocao = locomocao;
		this.vigilantes = vigilantes;
	}
	public Ronda() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Date getDataHoraInicio() {
		return this.dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}   
	public Date getDataHoraFim() {
		return this.dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}   
	public Float getLatUtima() {
		return this.latUltima;
	}

	public void setLatUtima(Float latUtima) {
		this.latUltima = latUtima;
	}   
	public Float getLonUltima() {
		return this.lonUltima;
	}

	public void setLonUltima(Float lonUltima) {
		this.lonUltima = lonUltima;
	}   
	public Date getDataHoraUltima() {
		return this.dataHoraUltima;
	}

	public void setDataHoraUltima(Date dataHoraUltima) {
		this.dataHoraUltima = dataHoraUltima;
	}   
	public Locomocao getLocomocao() {
		return this.locomocao;
	}

	public void setLocomocao(Locomocao locomocao) {
		this.locomocao = locomocao;
	}   
	public List<Pessoa> getVigilantes() {
		return this.vigilantes;
	}

	public void setVigilantes(List<Pessoa> vigilantes) {
		this.vigilantes = vigilantes;
	}
   
}
