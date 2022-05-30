import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idaluno;
	
	@Column (name = "nome", nullable = false)
	private String nome;
	
	@Column (name = "sexo", nullable = false)	
	private String sexo;
	
	@Column (name = "dt_nasc", nullable = false)
	private Date dt_nasc;
}
