import java.sql.Connection;

public class QueryManager {
	private Connection connection = null;

	public QueryManager(Connection connection) {
		this.connection = connection;
		if (this.connection.equals(null)) {
			System.out.println("Connection is not ready");
		}
	}

}
