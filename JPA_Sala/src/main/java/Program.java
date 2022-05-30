import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.Entity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Sala");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		Marca marca1 = new Marca(null, "Mitsubishi");
		Marca marca2 = new Marca(null, "Hyundai");
		Marca marca3 = new Marca(null, "Honda");
		Marca marca4 = new Marca(null, "Toyota");

		Modelo modelo1 = new Modelo(null, "AAA", 70);
		Modelo modelo2 = new Modelo(null, "BBB", 70);
		Modelo modelo3 = new Modelo(null, "CCC", 70);
		
		Automovel automovel1 = new Automovel(null, 1997, 1985, 50000f, "Carro barato", 0);
		Automovel automovel2 = new Automovel(null, 2003, 1995, 15000f, "Carro confortavel", 0);
		Automovel automovel3 = new Automovel(null, 2002, 1999, 80000f, "Carro seguro", 0);

		modelo2.adicionaMarca(marca3);
		automovel1.adicionaModelo(modelo2);
		
		em.persist(marca1);
		em.persist(marca2);
		em.persist(marca3);
		em.persist(marca4);
		
		em.persist(modelo1);
		em.persist(modelo2);
		em.persist(modelo3);
		
		em.persist(automovel1);
		em.persist(automovel2);
		em.persist(automovel3);

		em.getTransaction().commit();

		javax.persistence.Query query1 = em.createQuery("SELECT c FROM Automovel c");
		javax.persistence.Query query2 = em.createQuery("SELECT m FROM Modelo m");
		javax.persistence.Query query3 = em.createQuery("SELECT b FROM Marca b");

		List<Automovel> automoveis = query1.getResultList();
		List<Modelo> modelos = query2.getResultList();
		List<Marca> marcas = query3.getResultList();
		
		
		for (Automovel c : automoveis) {
			System.out.println("\nId do automovel: " + c.getId() + "\tAno de fabricacao: " + c.getAnoFabricacao() + "\tAno do modelo: " + c.getAnoModelo() + "\tObservacoes: " + c.getObservacoes() + "\tPreco: " + c.getPreco() + "\tKilometragem: " + c.getKilometragem());

		}
		
		for (Modelo m : modelos) {
			System.out.println("\nId do modelo: " + m.getId() + "\tDescricao do modelo: " + m.getDescricao());

		}
		
		for (Marca b : marcas) {
			System.out.println("\nId da marca: " + b.getId() + "\tNome da marca: " + b.getNome());

		}

		
		em.close();
		emf.close();
		

	}

}
