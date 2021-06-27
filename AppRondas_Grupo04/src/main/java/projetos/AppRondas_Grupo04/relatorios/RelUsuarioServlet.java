package projetos.AppRondas_Grupo04.relatorios;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RelUsuarioServlet
 */
@WebServlet("/Privada/Relatorios/RelUsuarioServlet")
public class RelUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HashMap<String, Object> parameters = new HashMap();
			RelatorioUtil.rodarRelatorioPDF("WEB-INF/relatorios/Usuario/Usuario.jasper", parameters, "RelUsuarios.pdf",
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().append("Não foi possível executar o relatório. Erro:" + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}