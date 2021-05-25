package projetos.AppRondas_Grupo04.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	static EntityManagerFactory emf = null;

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("AppRondas_Grupo04");
		}
		return emf.createEntityManager();
	}
}