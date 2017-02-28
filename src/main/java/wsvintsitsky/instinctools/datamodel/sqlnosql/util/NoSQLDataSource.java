package wsvintsitsky.instinctools.datamodel.sqlnosql.util;

import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.concurrent.locks.ReentrantLock;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import wsvintsitsky.instinctools.sqlnosql.exception.SingletonException;

public class NoSQLDataSource {

	private static NoSQLDataSource noSQLDataSource;
	private static ReentrantLock lock = new ReentrantLock();
	
	private String host;
	private Integer port;
	private String databaseName;

	private NoSQLDataSource() {
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	public DB getConnection() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient(host, port);
		return mongoClient.getDB(databaseName);
	}

	public static NoSQLDataSource getInstance() throws SingletonException {
		lock.lock();
		try {
			if (noSQLDataSource == null) {
				noSQLDataSource = new NoSQLDataSource();
				ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
				noSQLDataSource.setDatabaseName(resourceBundle.getString("nosql.host"));
				noSQLDataSource.setPort(Integer.parseInt(resourceBundle.getString("nosql.port")));
				noSQLDataSource.setDatabaseName(resourceBundle.getString("nosql.database"));
			}
		} finally {
			lock.unlock();
		}
		return noSQLDataSource;
	}
}


