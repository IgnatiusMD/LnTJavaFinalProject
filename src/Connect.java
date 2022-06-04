import java.sql.*;

public class Connect {
	
	Connection connect;
	ResultSet rs;
	PreparedStatement ps;

	public Connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/pt-pudding";
			String username = "root";
			String password = "";
			
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("Data failed to connect");
			e.printStackTrace();
		}
	}
	
	public ResultSet getData() {
		
		try {
			ps = connect.prepareStatement("SELECT * FROM menu");
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs;
	}
	
	public ResultSet insertData(String kode, String nama, String harga, String stok) {
		
		try {
			ps = connect.prepareStatement("INSERT INTO menu VALUES (?,?,?,?)");
			ps.setString(1, kode);
			ps.setString(2, nama);
			ps.setString(3, harga);
			ps.setString(4, stok);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs;
	}
	
	public ResultSet updateData(String kode, String nama, String harga, String stok) {
		
		try {
			ps = connect.prepareStatement("UPDATE menu SET 'nama' = ?, 'harga' = ?, 'stok' = ? WHERE 'kode' = ?");
			ps.setString(1, nama);
			ps.setString(2, harga);
			ps.setString(3, stok);
			ps.setString(4, kode);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs;
	}
	
	public ResultSet deleteData(String kode) {
		
		try {
			ps = connect.prepareStatement("DELETE FROM menu WHERE kode = (?)");
			ps.setString(1, kode);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs;
	}

}
