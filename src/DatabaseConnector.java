import java.sql.Connection;

public class DatabaseConnector {

	public static Connection connect() {
		Connection connection = null;
		
		try {
			
		} catch (Exception e) {
			System.out.println("Data failed to connect");
			e.printStackTrace();
		}
		
		return connection;
	}

}
