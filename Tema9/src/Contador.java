import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Contador {
	static final String SELECT = "select nombre, valor from contadores where nombre='contador1' for update";
	static final String UPDATE = "update contadores set valor=? where nombre='contador1'";


	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contadores", 
				"arancha2","arancha2*DAW")) {
			long t1, t2;
			t1 = System.nanoTime();
			int valor = 0;
			
			PreparedStatement update = con.prepareStatement(SELECT, 
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			for (int i=1; i<=1000; i++) {
				ResultSet res = update.executeQuery();
				if (res.next()) {
					valor = res.getInt(2)+1;
					res.updateInt(2, valor);
					res.updateRow();
				}
			}
			t2 = System.nanoTime();
			System.out.println(valor+", tiempo: "+ ((t2-t1)/1000000));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
