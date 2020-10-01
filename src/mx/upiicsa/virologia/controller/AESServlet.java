package mx.upiicsa.virologia.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.upiicsa.virologia.algoritmos.AES;


/**
 * Servlet implementation class AESServlet
 */
@WebServlet("/AESServlet")
public class AESServlet extends HttpServlet {
	
	String secretKey = "virologiacriptog";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AESServlet() {
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
		
		if(opcion == 1) { //cirfrar
			Base64.Encoder baseEncoder = Base64.getEncoder();
			// Encoding string  
	        String cifrada = baseEncoder.encodeToString(texto.getBytes());
	        
			String cifradaAES = AES.encrypt(cifrada);
			sesion.removeAttribute("descifradaAES");
	        sesion.setAttribute("cifradaAES", cifradaAES);
	        request.getRequestDispatcher("/AES.jsp").forward(request, response);
		}else { //descifrar
			String decifradaAES = AES.decrypt(texto);
			Base64.Decoder decoderB = Base64.getDecoder();
	        String decifradaB = new String(decoderB.decode(decifradaAES));
	        sesion.removeAttribute("cifradaAES");
	        sesion.setAttribute("descifradaAES", decifradaB);
	        
	        request.getRequestDispatcher("/AES.jsp").forward(request, response);
		}
	}

}
