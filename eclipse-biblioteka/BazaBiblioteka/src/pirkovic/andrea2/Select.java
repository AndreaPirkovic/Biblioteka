package pirkovic.andrea2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Select {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String username="root";
		String password = "";
		System.out.println("Konekcija....");
		try (Connection conn= DriverManager.getConnection(url,username,password)){
			
			
			String sqlselect = "SELECT * from knjige";
		
			java.sql.Statement stmt=conn.createStatement();
		ResultSet result= stmt.executeQuery(sqlselect);// izvrsavanje(namena) nad bazom
		while(result.next()) { //prolazak kroz skup podataka iz baze dokle god ima sledeci u bazi
			Integer knjigaID = result.getInt(1);
			Long ISBN= result.getLong(2);
			String naziv = result.getString(3);
			String jezik= result.getString(4);
			String izdavac= result.getString(5);
			Integer brKnjigaNaStanju = result.getInt(6);
			
			StringBuilder builder = new StringBuilder();
			builder.append("KnjigaID: ");
			builder.append(knjigaID);
			builder.append("\nISBN: ");
			builder.append(ISBN);
			builder.append("\nnaziv: ");
			builder.append(naziv);
			builder.append("\njezik: ");
			builder.append(jezik);
			builder.append("\nIzdavac: ");
			builder.append(izdavac);
			builder.append("\nbroj knjiga na stanju: ");
			builder.append(brKnjigaNaStanju);
			System.out.println(builder.toString());
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}