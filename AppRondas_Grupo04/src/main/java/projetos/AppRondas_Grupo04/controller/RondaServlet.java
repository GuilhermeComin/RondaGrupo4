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

import projetos.AppRondas_Grupo04.domain.Pessoa;
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
			} else if(request.getParameter("vigilantes") != null) {
				vigilantes(request, response);
			} else if(request.getParameter("incluirVigilante") != null) {
				incluirVigilante(request, response);
			} else if(request.getParameter("excluirVigilante") != null) {
				excluirVigilante(request, response);
			} else {
				listar(request, response);
			}
		}
    
    private void vigilantes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer idRonda = Integer.parseInt(request.getParameter("vigilantes"));
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		@SuppressWarnings("unchecked")
		List<Pessoa> pessoas = em.createQuery("from Pessoa").getResultList();
		Ronda r = em.find(Ronda.class, idRonda);
		em.close();
		
		request.setAttribute("r", r);
		request.setAttribute("pessoas", pessoas);
		request.getRequestDispatcher("RondaVigilantes.jsp").forward(request, response);
	}
	
	private void incluirVigilante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		Integer idRonda = Integer.parseInt(request.getParameter("idRonda"));
		Integer idPessoa = Integer.parseInt(request.getParameter("vigilante"));
		
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			// A ronda onde deve ser incluído
			Ronda r = em.find(Ronda.class, idRonda);
			// O vigilante a ser incluído na ronda
			Pessoa p = em.find(Pessoa.class, idPessoa);
			
			// Adicionar o vigilante na ronda
			r.getVigilantes().add(p);
			
			// Vai salvar em cascata os vigilantes adicionados (cascade=ALL na classe)
			em.merge(r);
			em.getTransaction().commit();
			
			@SuppressWarnings("unchecked")
			List<Pessoa> pessoas = em.createQuery("from Pessoa").getResultList();
			em.close();
			
			request.setAttribute("r", r);
			request.setAttribute("pessoas", pessoas);
			request.getRequestDispatcher("RondaVigilantes.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	private void excluirVigilante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		Integer idRonda = Integer.parseInt(request.getParameter("idRonda"));
		Integer idPessoa = Integer.parseInt(request.getParameter("excluirVigilante"));
		
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			// A ronda onde deve ser excluído
			Ronda r = em.find(Ronda.class, idRonda);
			// O vigilante a ser excluído na ronda
			Pessoa p = em.find(Pessoa.class, idPessoa);
			
			// Remove o vigilante na ronda
			r.getVigilantes().remove(p);
			
			// Vai salvar em cascata os vigilantes removidos (cascade=ALL na classe)
			em.merge(r);
			em.getTransaction().commit();
			
			@SuppressWarnings("unchecked")
			List<Pessoa> pessoas = em.createQuery("from Pessoa").getResultList();
			em.close();
			
			request.setAttribute("r", r);
			request.setAttribute("pessoas", pessoas);
			request.getRequestDispatcher("RondaVigilantes.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
		
    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("excluir"));
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Ronda.class, id));
		em.getTransaction().commit();		
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("alterar"));
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
					request.getParameter("id").equals("") ? null : Integer.parseInt(request.getParameter("id")), 
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
