package wsvintsitsky.instinctools.boot;

import java.util.ResourceBundle;

import wsvintsitsky.instinctools.config.ConfigManager;
import wsvintsitsky.instinctools.sqlnosql.dataaccess.ClientDao;
import wsvintsitsky.instinctools.sqlnosql.dataaccess.jdbc.impl.ClientDaoImpl;
import wsvintsitsky.instinctools.sqlnosql.datamodel.Client;
import wsvintsitsky.instinctools.sqlnosql.datamodel.util.SchemaNameAwareBasicDataSource;

public class JdbcBoot implements IBoot {

	@Override
	public void boot() {
		SchemaNameAwareBasicDataSource dataSource = new SchemaNameAwareBasicDataSource();
		ResourceBundle configBundle = ConfigManager.getInstance().getConfigBundle();
		dataSource.setDriverClassName(configBundle.getString("jdbc.driverClassName"));
		dataSource.setUrl(configBundle.getString("jdbc.url"));
		dataSource.setUsername(configBundle.getString("jdbc.username"));
		dataSource.setPassword(configBundle.getString("jdbc.password"));
		dataSource.setSchema(configBundle.getString("jdbc.schema"));
		
		ClientDao clientDao = new ClientDaoImpl(dataSource);
		
		Client client = new Client();
		client.setName("name");
		client.setEmail("email");
		client.setPassword("password");
		
		try {
			clientDao.insert(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(client.getId());
	}
}