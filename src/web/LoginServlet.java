package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.admin;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int b=0;
		admin a=new admin();
		
		//Récup info
		
				String login=(String)req.getParameter("login");
				String pass=(String)req.getParameter("pass");
				
				 a=admin.auth(login, pass);
					if(a.getId()==0){
						req.getRequestDispatcher("login.html").forward(req, resp);
						
					}
					else{
						// création de la session
						HttpSession session =req.getSession();
						//Ajouter un attribut dans l'objet session
						session.setAttribute("login", login);
						session.setAttribute("pass", pass);
						
						session.setAttribute("id", a.getId());
						
						
							req.setAttribute("id", a.getId());
							req.getRequestDispatcher("TableEnfants.jsp").forward(req, resp);
						
						
						
					}
					
				
	}

}
