package pirkovic.andrea1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String username="root";
		String password = "";
		System.out.println("Konekcija....");
		try (Connection conn= DriverManager.getConnection(url,username,password)){
			
			System.out.println("Uspesna konekcija ka bazi.");
		
		String sqlupdate="UPDATE biblioteka SET naziv=?,mesto=?,ulica=?,brojUlice=?,telefon=? WHERE BibliotekaID=?";
		
		
		PreparedStatement ps= conn.prepareStatement(sqlupdate);
		
		ps.setString(1, "Narodna biblioteka ");
		ps.setString(2, "Beograd");
		ps.setString(3, "Skerliceva");
		ps.setString(4, "2");
		ps.setString(5, "0112451242");
		ps.setInt(6, 1);
		
		int promenjenPodatak = ps.executeUpdate();
		
		if(promenjenPodatak>0)
			System.out.println("Uspesno je izvrsena izmena.");
		
		
		
		} catch (SQLException e) {
		e.printStackTrace();
	}

}}