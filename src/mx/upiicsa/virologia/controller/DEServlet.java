package mx.upiicsa.virologia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.upiicsa.virologia.algoritmos.DES;
import mx.upiicsa.virologia.modelos.InfoDes;

/**
 * Servlet implementation class DEServlet
 */
@WebServlet("/DEServlet")
public class DEServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DEServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		int opcion = Integer.parseInt(request.getParameter("opcion"));
		String texto = request.getParameter("texto");
		InfoDes infoDes = new InfoDes();
		
		DES desCipher = new DES();
	
		if(opcion == 1) {
			infoDes.setCadenaDesencriptada(texto);
			infoDes = desCipher.encrypt(infoDes);
			
	        infoDes.setCadenaDesencriptada(null);
			
			sesion.setAttribute("infoDes", infoDes);
	        
	        request.getRequestDispatcher("/DES.jsp").forward(request, response);
		}else {
			if(sesion.getAttribute("infoDes") != null) {
				infoDes = (InfoDes) sesion.getAttribute("infoDes");
				infoDes = desCipher.decrypt(infoDes);
				infoDes.setCadenaEncriptada(null);
				sesion.setAttribute("infoDes", infoDes);
				request.getRequestDispatcher("/DES.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/DES.jsp").forward(request, response);
			}
		}
	}

}
