import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseServer {
	//private final String url = "jdbc:oracle:thin:@claros.cs.purdue.edu:1524:strep";
	private final String url = "jdbc:mysql://mydb.ics.purdue.edu:3306/chen869";

	private final String host = "chen869";
	//private final String pw = "cs307cs252";
	private final String pw = "cs252";

	private Connection connection = null;

	public DatabaseServer() {
		createConnection();
	}

	public void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		try {
			connection = DriverManager.getConnection(url, host, pw);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("Connection is created successfully!");
	}

	public Connection getConnection() {
		return this.connection;
	}
	
	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection is closed successfully!");
	}

}
