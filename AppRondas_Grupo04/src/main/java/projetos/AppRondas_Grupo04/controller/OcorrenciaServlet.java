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

import net.iamvegan.multipartrequest.HttpServletMultipartRequest;
import projetos.AppRondas_Grupo04.jpa.JpaUtil;
import projetos.AppRondas_Grupo04.uteis.Upload;
import projetos.AppRondas_Grupo04.domain.Localizacao;
import projetos.AppRondas_Grupo04.domain.Ocorrencia;
import projetos.AppRondas_Grupo04.domain.Ronda;

/**
 * Servlet implementation class LocalizacaoServlet
 */
@WebServlet("/Privada/Ocorrencia/OcorrenciaServlet")
public class OcorrenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OcorrenciaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request = new HttpServletMultipartRequest(
    			request,
    			HttpServletMultipartRequest.MAX_CONTENT_LENGTH,
    			HttpServletMultipartRequest.SAVE_TO_TMPDIR,
    			HttpServletMultipartRequest.IGNORE_ON_MAX_LENGTH,
    			HttpServletMultipartRequest.DEFAULT_ENCODING);

    	
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
			} else if (request.getParameter("alterarFoto") != null) {
				alterarFoto(request, response);
			} else if (request.getParameter("gravarFoto") != null) {
				gravarFoto(request, response);
    		} else {
				listar(request, response);
			}
		}
		
    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("excluir"));
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Ocorrencia.class, id));
		em.getTransaction().commit();		
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("alterar"));
		EntityManager em = JpaUtil.getEntityManager();
		Ocorrencia o = em.find(Ocorrencia.class, id);
		List<Ronda> rondas = em.createQuery("from Ocorrencia").getResultList();
		em.close();
		request.setAttribute("o", o);
		request.setAttribute("rondas", rondas);
		request.getRequestDispatcher("OcorrenciaForm.jsp").forward(request, response);
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List<Ronda> rondas = em.createQuery("from Ronda").getResultList();
		em.close();
		request.setAttribute("rondas", rondas);
		request.getRequestDispatcher("OcorrenciaForm.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List<Ocorrencia> lista = em.createQuery("from Ocorrencia").getResultList();
		em.close();
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("OcorrenciaList.jsp").forward(request, response);
	}
	
	private void alterarFoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("alterarFoto"));
		EntityManager em = JpaUtil.getEntityManager();
		Ocorrencia o = em.find(Ocorrencia.class, id);
		List<Ronda> rondas = em.createQuery("from Ocorrencia").getResultList();
		em.close();
		request.setAttribute("o", o);
		request.setAttribute("rondas", rondas);
		request.getRequestDispatcher("OcorrenciaFoto.jsp").forward(request, response);
	}
	
	private void gravarFoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		// Gravar foto na pasta uploads do sistema de arquivos
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			Ocorrencia o = em.find(Ocorrencia.class, Integer.parseInt(request.getParameter("id")));
			
			if (request.getParameter("foto") != null) {
				String nomeArquivo = "foto"+o.getId()+".jpg";
				// pegar o caminho de contexto de execução da aplicação para a pasta uploads
				String caminho = getServletConfig().getServletContext().getRealPath("/") + "Privada/uploads";
				// copiar arquivo de upload para a pasta
				Upload.copiarArquivo((HttpServletMultipartRequest) request, "foto", caminho, nomeArquivo);
			}
			// Colocar foto no banco de dados
			o.setFoto(Upload.getBytesArquivo((HttpServletMultipartRequest) request, "foto"));
			em.merge(o);
			em.getTransaction().commit();	
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			em.close();
			listar(request, response);
		}
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			Ocorrencia o = inicializarObjeto(request, em);
			em.merge(o);
			em.getTransaction().commit();	
			List<Ocorrencia> lista = em.createQuery("from Ocorrencia").getResultList();
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("OcorrenciaList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			em.close();
		}
	}

		private Ocorrencia inicializarObjeto(HttpServletRequest request, EntityManager em) throws Exception {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 2021-05-18T15:30
			// tratar a ronda que foi informada
			Ronda ronda = em.find(Ronda.class, Integer.parseInt(request.getParameter("ronda")) );
			
			Ocorrencia o = new Ocorrencia(
					request.getParameter("id").equals("") ? null : Integer.parseInt(request.getParameter("id")), 
					sdf.parse(request.getParameter("dataHora").replaceAll("T", " ")),
					request.getParameter("titulo"),
					request.getParameter("descricao"),
					Long.parseLong(request.getParameter("lat")),
					Long.parseLong(request.getParameter("lon")),
					ronda);
			return o;
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
