package projetos.AppRondas_Grupo04.jpa;

import javax.persistence.EntityManager;

import projetos.AppRondas_Grupo04.jpa.JpaUtil;
import projetos.AppRondas_Grupo04.domain.Usuario;

public class InserirUsuarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.merge(new Usuario(1,"admin", "admin@admin", "123"));
		em.merge(new Usuario(2,"Otávio Monteiro Rossoni", "182744@upf.br", "123"));
		em.getTransaction().commit();
	}
}
