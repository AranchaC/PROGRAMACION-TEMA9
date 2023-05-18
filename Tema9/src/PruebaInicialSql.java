import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// Añadido en ClassPath /usr/share/java/mariadb-java-client.jar del paquete libmariadb-java en Debian
// https://stackoverflow.com/questions/23020857/connect-to-mariadb-from-java-application-in-netbeans-on-linux-mageia
public class PruebaInicialSql {
	public static void main(String[] args) {
		try {
			//Class.forName("org.mariadb.jdbc.Driver");
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/ropa", "arancha1",
					"arancha1*");
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("select * from persona;");
			while (res.next()) {
				System.out.println("ID-"+res.getInt("id")+": NOMBRE-"+ res.getString("nombre") + ": F.NAC-" + res.getString("fnac"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
} // class