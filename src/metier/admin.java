package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class admin {
private int id;
private String nom;
private String prenom;
private String login;
private String pass;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public admin() {
	super();
	// TODO Auto-generated constructor stub
}
public admin(int id, String nom, String prenom, String login, String pass) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.login = login;
	this.pass = pass;
}
public admin(String nom, String prenom, String login, String pass) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.login = login;
	this.pass = pass;
}


public static	admin auth(String login, String pass){
	int b=0;
	admin a=new admin();
	 try {
    Connection cn=Singleton.getConnection();
	PreparedStatement pr = (PreparedStatement) cn.prepareStatement("select * from admin where login=? and pass=?");
	pr.setString(1,login);
	pr.setString(2,pass);
	ResultSet rs=pr.executeQuery();
	 if(rs.next()){
		
		 //a.setIdA();
		// a.setLogin(rs.getString("login"));
		 //a.setPass(rs.getString("pass"));
		
		 a.setId(rs.getInt("id"));
		 a.setNom(rs.getString("nom"));
		 a.setPrenom(rs.getString("prenom"));
		 a.setLogin(rs.getString("login"));
		 a.setPass(rs.getString("pass"));
		
		 
	 } 
	 } catch (Exception e1) {
			
			e1.printStackTrace();
		}
	
	
	 return a;

}

public boolean addA(){
	boolean res=false;
	
	Connection conn=Singleton.getConnection();
	//preparaion de la req
	String req="insert into admin values(null,?,?,?,?)";
	
	try{
		PreparedStatement ps =(PreparedStatement)conn.prepareStatement(req);
		ps.setString(1, this.nom);
		ps.setString(2, this.prenom);
		ps.setString(3, this.login);
		ps.setString(4, this.pass);
		
		ps.executeUpdate();
		res=true;
		System.out.println("admin ajouté avec succes");
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println("prob d'ajout du admin");
	}
	return res;
}

}
