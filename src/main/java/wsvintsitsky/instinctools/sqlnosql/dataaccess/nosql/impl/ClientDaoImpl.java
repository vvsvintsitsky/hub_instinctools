package wsvintsitsky.instinctools.sqlnosql.dataaccess.nosql.impl;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import wsvintsitsky.instinctools.sqlnosql.dataaccess.ClientDao;
import wsvintsitsky.instinctools.sqlnosql.dataaccess.nosql.impl.AbstractDaoImpl;
import wsvintsitsky.instinctools.sqlnosql.datamodel.Client;

public class ClientDaoImpl extends AbstractDaoImpl<Client, Long> implements ClientDao {

	public ClientDaoImpl(DB database) {
		super(database);
	}

	@Override
	public Client find(Long id) throws Exception {
		DBCollection table = getDatabase().getCollection(Client.class.getSimpleName());

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("id", id);

		DBCursor cursor = table.find(searchQuery);

		Client client = null;
		while (cursor.hasNext()) {
			DBObject result = cursor.next();
			client = new Client();
			client.setId((Long)result.get("id"));
			client.setName((String)result.get("name"));
			client.setEmail((String)result.get("email"));
			client.setPassword((String)result.get("password"));
		}
		return client;
	}

	@Override
	public Client insert(Client entity) throws Exception {
		DBCollection table = getDatabase().getCollection(Client.class.getSimpleName());
		BasicDBObject document = new BasicDBObject();
		ObjectId objectId = new ObjectId();
		document.put("id", objectId.getTime());
		document.put("name", entity.getName());
		document.put("email", entity.getEmail());
		document.put("password", entity.getPassword());
		entity.setId(objectId.getTime());
		table.insert(document);
		return entity;
	}

	@Override
	public Client update(Client entity) throws Exception {
		DBCollection table = getDatabase().getCollection(Client.class.getSimpleName());
		
		BasicDBObject query = new BasicDBObject();
		query.put("id", entity.getId());

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("id", new ObjectId().getTime());
		newDocument.put("name", entity.getName());
		newDocument.put("email", entity.getEmail());
		newDocument.put("password", entity.getPassword());

		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);
		
		table.update(query, updateObj);
		
		return entity;
	}

	@Override
	public void delete(Long id) throws Exception {
		DBCollection table = getDatabase().getCollection(Client.class.getSimpleName());

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("id", id);

		table.remove(searchQuery);
	}

}
