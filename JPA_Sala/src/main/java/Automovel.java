import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;

@Entity
public class Automovel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "anoFabricacao", nullable = false)
	private Integer anoFabricacao;
	
	@Column (name = "anoModelo", nullable = false)
	private Integer anoModelo;
	
	@Column (name = "preco", nullable = false)
	private Float preco;
	
	@Column (name = "observacoes", nullable = false)
	private String observacoes;
	
	@Column (name = "kilometragem", nullable = false)
	private Integer kilometragem;
	
	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;

	public Automovel() {
		
	}
			
	public Automovel(Integer id, Integer anoFabricacao, Integer anoModelo, Float preco, String observacoes,
			Integer kilometragem) {
		this.id = id;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.preco = preco;
		this.observacoes = observacoes;
		this.kilometragem = kilometragem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Integer kilometragem) {
		this.kilometragem = kilometragem;
	}
	
	public void adicionaModelo(Modelo modelo) {
		this.modelo = modelo;
		modelo.adicionaAutomovel(this);
	}
	
	public void removeModelo(Modelo modelo) {
		this.modelo = null;
		modelo.removeAutomovel(null);;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoFabricacao, anoModelo, id, kilometragem, observacoes, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovel other = (Automovel) obj;
		return Objects.equals(anoFabricacao, other.anoFabricacao) && Objects.equals(anoModelo, other.anoModelo)
				&& Objects.equals(id, other.id) && Objects.equals(kilometragem, other.kilometragem)
				&& Objects.equals(observacoes, other.observacoes) && Objects.equals(preco, other.preco);
	}
			
	
	
}
