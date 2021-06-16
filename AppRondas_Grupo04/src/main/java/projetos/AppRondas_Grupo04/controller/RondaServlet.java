package projetos.AppRondas_Grupo04.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetos.AppRondas_Grupo04.jpa.JpaUtil;
import projetos.AppRondas_Grupo04.domain.Localizacao;
import projetos.AppRondas_Grupo04.domain.Locomocao;
import projetos.AppRondas_Grupo04.domain.Ocorrencia;
import projetos.AppRondas_Grupo04.domain.Ronda;

/**
 * Servlet implementation class LocalizacaoServlet
 */
@WebServlet("/Privada/Ronda/RondaServlet")
public class RondaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RondaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("gravar") != null) {
	           gravar(request, response);
			} else if (request.getParameter("incluir") != null) {
				incluir(request, response);
			} else if (request.getParameter("alterar") != null) {
				alterar(request, response);
			} else if (request.getParameter("excluir") != null) {
				excluir(request, response);
			} else if (request.getParameter("cancelar") != null) {
				cancelar(request, response);
			} else {
				listar(request, response);
			}
		}
		
    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("excluir"));
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Ronda.class, id));
		em.getTransaction().commit();		
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("alterar"));
		EntityManager em = JpaUtil.getEntityManager();
		Ronda o = em.find(Ronda.class, id);
		List<Locomocao> locomocoes = em.createQuery("from Locomocao").getResultList();
		em.close();
		request.setAttribute("o", o);
		request.setAttribute("locomocoes", locomocoes);
		request.getRequestDispatcher("RondaForm.jsp").forward(request, response);
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List<Locomocao> locomocoes = em.createQuery("from Locomocao").getResultList();
		em.close();
		request.setAttribute("locomocoes", locomocoes);
		request.getRequestDispatcher("RondaForm.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List<Ronda> lista = em.createQuery("from Ronda").getResultList();
		em.close();
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("RondaList.jsp").forward(request, response);
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			Ronda o = inicializarObjeto(request, em);
			em.merge(o);
			em.getTransaction().commit();	
			List<Ronda> lista = em.createQuery("from Ronda").getResultList();
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("RondaList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

		private Ronda inicializarObjeto(HttpServletRequest request, EntityManager em) throws Exception {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 2021-05-18T15:30
			// tratar a ronda que foi informada
			Locomocao locomocao = em.find(Locomocao.class, Integer.parseInt(request.getParameter("locomocao")) );
			
			Ronda o = new Ronda(
					request.getParameter("id").equals("") ? null : Long.parseLong(request.getParameter("id")), 
					sdf.parse(request.getParameter("dataHoraInicio").replaceAll("T", " ")),
					sdf.parse(request.getParameter("dataHoraFim").replaceAll("T", " ")),
					Float.parseFloat(request.getParameter("latUltima")),
					Float.parseFloat(request.getParameter("lonUltima")),
					sdf.parse(request.getParameter("dataHoraUltima").replaceAll("T", " ")),
					locomocao,
					null);
			return o;
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
