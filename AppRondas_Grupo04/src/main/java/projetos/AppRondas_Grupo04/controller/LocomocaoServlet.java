package projetos.AppRondas_Grupo04.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetos.AppRondas_Grupo04.jpa.JpaUtil;
import projetos.AppRondas_Grupo04.domain.Locomocao;

/**
 * Servlet implementation class LocomocaoServlet
 */
@WebServlet("/Privada/Locomocao/LocomocaoServlet")
public class LocomocaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocomocaoServlet() {
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
		} else {// default = consultar
			listar(request, response);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
        List<Locomocao> lista = em.createQuery("from Locomocao").getResultList();
        em.close();
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("LocomocaoList.jsp").forward(request, response);
	}

	private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("excluir"));
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Locomocao.class, id));
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("alterar"));
		EntityManager em = JpaUtil.getEntityManager();
		Locomocao o = em.find(Locomocao.class, id);
		em.close();
		request.setAttribute("o", o);
		request.getRequestDispatcher("LocomocaoForm.jsp").forward(request, response);
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("LocomocaoForm.jsp").forward(request, response);
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Locomocao o = inicializarObjeto(request);

		// Aqui introduzimos o código para persistir o IMC no BD
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(o);// armazena o o objeto no BD - tanto inclui como altera
		em.getTransaction().commit();

		// vamos pegar a lista de IMC da tablea do BD
		List<Locomocao> lista = em.createQuery("from Locomocao").getResultList();
		em.close();

		// atualizar a lista na requisição
		request.setAttribute("lista", lista);

		// vamos encaminhar a requisição para um JSP renderizar uma resposta
		request.getRequestDispatcher("LocomocaoList.jsp").forward(request, response);
	}

	private Locomocao inicializarObjeto(HttpServletRequest request) {
		Locomocao o = new Locomocao(
				request.getParameter("id").equals("") ? null : Integer.parseInt(request.getParameter("id")), 
				request.getParameter("descricao"),
				request.getParameter("placa"));
		return o;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
