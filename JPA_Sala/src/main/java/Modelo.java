import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Modelo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "potencia", nullable = false)
	private Integer potencia;

	@OneToMany(mappedBy = "modelo")
	private List<Automovel> automoveis = new ArrayList<Automovel>();

	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;

	public Modelo() {

	}

	public Modelo(Integer id, String descricao, Integer potencia) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.potencia = potencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void adicionaAutomovel(Automovel automovel) {
		this.automoveis.add(automovel);
			automovel.setModelo(this);
		
	}

	public void removeAutomovel(Automovel automovel) {
		if (this.automoveis.contains(automovel)) {
			this.automoveis.remove(automovel);
			automovel.setModelo(null);
		}
	}

	public void adicionaMarca(Marca marca) {
		this.marca = marca;
		marca.adicionaModelo(this);
	}

	public void removeMarca(Marca marca) {
		this.marca = null;
		marca.removeModelo(this);;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id, potencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(potencia, other.potencia);
	}



}
