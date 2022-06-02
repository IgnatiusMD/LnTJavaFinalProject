import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseController {
	
	Connection connection;

	public DatabaseController() {
		try {
			initialConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void initialConnection() throws SQLException {
		connection = DatabaseConnector.connect();
		if (connection == null) {
			throw new SQLException("Connection");
		}
	}

}
