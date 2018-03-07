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

import metier.Crise;



@MultipartConfig
(maxFileSize=1024*1024*10)     // 10MB

@WebServlet("/AjoutCrise")
public class AjoutCrise extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AjoutCrise() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom,date,cause;
		int duree;
		
		
		
		
		nom=request.getParameter("nomE");
		date=request.getParameter("date");
		duree=Integer.parseInt(request.getParameter("duree"));
		cause=request.getParameter("cause");
		
		

		Crise p=new Crise(nom,date,duree,cause);
		boolean res=p.addC();
		
		
		
		

		request.getRequestDispatcher("TableEnfants.jsp").forward(request, response);
		
		
	}
	
	
		
	

}
