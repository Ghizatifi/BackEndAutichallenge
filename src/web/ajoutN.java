package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Enfant;

/**
 * Servlet implementation class modServ
 */
@WebServlet("/ajoutN")
public class ajoutN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajoutN() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomE=(String)request.getParameter("nomE");
		String nomC=(String)request.getParameter("nomC");
		int note=Integer.parseInt(request.getParameter("note"));
       
        
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd");
        String laDateDuJour = sdf.format(date);
        
        Date date1 = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
        String heure = sdf1.format(date1);
        
        Enfant v=new Enfant(nomE,note,nomC,laDateDuJour,heure);
		boolean res=v.ajouter();
		if(res==true){
		request.getRequestDispatcher("TableEnfants.jsp").forward(request, response);
		}
	}

}
