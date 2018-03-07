package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class Enfant {
	private int idE;
	private String nom;
	private String prenom;
	private int age;
	private String nomM;
	private String nomP;
	private String tel;
	private String email;
	private int note;
	private String nomC;
	private String date;
	private String heure;
	
	
	
	
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIdE() {
		return idE;
	}
	public void setIdE(int idE) {
		this.idE = idE;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNomM() {
		return nomM;
	}
	public void setNomM(String nomM) {
		this.nomM = nomM;
	}
	public String getNomP() {
		return nomP;
	}
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Enfant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enfant(int idE, String nom, String prenom, int age, String nomM, String nomP, String tel, String email) {
		super();
		this.idE = idE;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.nomM = nomM;
		this.nomP = nomP;
		this.tel = tel;
		this.email = email;
	}
	
	
	public Enfant(String nom, int note, String nomC, String date,String heure) {
		super();
		this.nom = nom;
		this.note = note;
		this.nomC = nomC;
		this.date = date;
		this.heure=heure;
	}
	//affichaage
	public static ArrayList<Enfant> getAllF(){
		ArrayList<Enfant> listEnfant =new ArrayList<Enfant>();
		try {
			Connection conn=Singleton.getConnection();
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement("SELECT * FROM enfant");
			ResultSet rs=pr.executeQuery();
			while(rs.next()){
				Enfant v= new Enfant();
				v.setIdE(rs.getInt("idE"));
				v.setNom(rs.getString("nom"));
				v.setPrenom(rs.getString("prenom"));
				v.setAge(rs.getInt("age"));
				v.setNomM(rs.getString("nomM"));
				v.setNomP(rs.getString("nomP"));
				v.setTel(rs.getString("tel"));
				v.setEmail(rs.getString("Email"));
				listEnfant.add(v);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return listEnfant;
	}
	
	public static Enfant detail(int id){
		Enfant v=new Enfant();
		Connection conn=Singleton.getConnection();
		try{
			PreparedStatement ps =(PreparedStatement)conn.prepareStatement("select * from enfant where idE=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				v.setIdE(rs.getInt("idE"));
				v.setNom(rs.getString("nom"));
				v.setPrenom(rs.getString("prenom"));
				v.setAge(rs.getInt("age"));
				v.setNomM(rs.getString("nomM"));
				v.setNomP(rs.getString("nomP"));
				v.setTel(rs.getString("tel"));
				v.setEmail(rs.getString("Email"));
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("prob de chargement  du Enfant");
		}
		
		return v;
	}
	public boolean ajouter(){
		
		boolean res=false;
		
		Connection conn=Singleton.getConnection();
		//preparaion de la req
		String req="insert into result values(null,?,?,?,?,?)";
		
		try{
			PreparedStatement ps =(PreparedStatement)conn.prepareStatement(req);
			ps.setString(1, this.nomC);
			ps.setInt(2, this.note);
			ps.setString(3, this.date);
			ps.setString(4, this.nom);
			ps.setString(5, this.heure);
			
			ps.executeUpdate();
			res=true;
			System.out.println("result ajouté avec succes");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("prob d'ajout du result");
		}
		return res;
	}
	
	public static ArrayList<Enfant>  Result(String nom){
		ArrayList<Enfant> listEnfant =new ArrayList<Enfant>();
		Connection conn=Singleton.getConnection();
		try{
			PreparedStatement ps =(PreparedStatement)conn.prepareStatement("select * from result where NomE=?");
			ps.setString(1,nom);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Enfant v= new Enfant();
				
				v.setNom(rs.getString("NomE"));
				v.setNomC(rs.getString("nomCours"));
				v.setDate(rs.getString("date"));
				v.setNote(rs.getInt("note"));
				listEnfant.add(v);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("prob de chargement  du Enfant");
		}
		
		return listEnfant;
	}

}
