package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class Crise {
private int id;
private String nomE;
private String date;
private int duree;
private String cause;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNomE() {
	return nomE;
}
public void setNomE(String nomE) {
	this.nomE = nomE;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getDuree() {
	return duree;
}
public void setDuree(int duree) {
	this.duree = duree;
}
public String getCause() {
	return cause;
}
public void setCause(String cause) {
	this.cause = cause;
}
public Crise(int id, String nomE, String date, int duree, String cause) {
	super();
	this.id = id;
	this.nomE = nomE;
	this.date = date;
	this.duree = duree;
	this.cause = cause;
}
public Crise(String nomE, String date, int duree, String cause) {
	super();
	this.nomE = nomE;
	this.date = date;
	this.duree = duree;
	this.cause = cause;
}
public Crise() {
	super();
	// TODO Auto-generated constructor stub
}

public boolean addC(){
	boolean res=false;
	
	Connection conn=Singleton.getConnection();
	//preparaion de la req
	String req="insert into crise values(null,?,?,?,?)";
	
	try{
		PreparedStatement ps =(PreparedStatement)conn.prepareStatement(req);
		ps.setString(1, this.nomE);
		ps.setString(2, this.date);
		ps.setInt(3, this.duree);
		ps.setString(4, this.cause);
		
		ps.executeUpdate();
		res=true;
		System.out.println("crise ajouté avec succes");
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println("prob d'ajout du crise");
	}
	return res;
}

public static ArrayList<Crise>  check(String nom){
	ArrayList<Crise> listCrise =new ArrayList<Crise>();
	Connection conn=Singleton.getConnection();
	try{
		PreparedStatement ps =(PreparedStatement)conn.prepareStatement("select * from crise where nomE=?");
		ps.setString(1,nom);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Crise v= new Crise();
			v.setId(rs.getInt("id"));
			v.setNomE(rs.getString("nomE"));
			v.setDate(rs.getString("date"));
			v.setDuree(rs.getInt("duree"));
			v.setCause(rs.getString("cause"));
			listCrise.add(v);
		}
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println("prob de chargement  du crise");
	}
	
	return listCrise;
}

public static ArrayList<Crise> getAll(){
	ArrayList<Crise> listEnfant =new ArrayList<Crise>();
	try {
		Connection conn=Singleton.getConnection();
		PreparedStatement pr = (PreparedStatement) conn.prepareStatement("SELECT * FROM crise");
		ResultSet rs=pr.executeQuery();
		while(rs.next()){
			Crise v= new Crise();
			v.setId(rs.getInt("id"));
			v.setNomE(rs.getString("nomE"));
			v.setDate(rs.getString("date"));
			v.setDuree(rs.getInt("duree"));
			v.setCause(rs.getString("cause"));
			
			listEnfant.add(v);
		}
		
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	return listEnfant;
}



}
