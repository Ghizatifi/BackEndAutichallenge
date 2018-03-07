package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import metier.admin;



@MultipartConfig
(maxFileSize=1024*1024*10)     // 10MB

@WebServlet("/AjoutAdmin")
public class AjoutAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AjoutAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom,prenom,login,pass;
		
		
		nom=request.getParameter("nom");
		prenom=request.getParameter("prenom");
		login=request.getParameter("login");
		pass=request.getParameter("pass");
		
		

		admin p=new admin(nom,prenom,login,pass);
		boolean res=p.addA();
		
		
		
		

		request.getRequestDispatcher("login.html").forward(request, response);
		
		
	}
	
	
		
	

}
