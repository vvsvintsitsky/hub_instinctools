package wsvintsitsky.instinctools.dataaccess.sqlnosql.nosql.impl;

import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import wsvintsitsky.instinctools.dataaccess.BookDao;
import wsvintsitsky.instinctools.datamodel.sqlnosql.Book;
import wsvintsitsky.instinctools.datamodel.sqlnosql.Client;

public class BookDaoImpl extends AbstractDaoImpl<Book, Long> implements BookDao {

	public BookDaoImpl(DB database) {
		super(database);
	}

	@Override
	public Book find(Long id) throws Exception {
		DBCollection table = getDatabase().getCollection(Book.class.getSimpleName());

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("id", id);

		DBCursor cursor = table.find(searchQuery);

		Book book = null;
		while (cursor.hasNext()) {
			DBObject result = cursor.next();
			book = new Book();
			book.setId((Long) result.get("id"));
			book.setName((String) result.get("name"));
		}
		return book;
	}

	@Override
	public Book insert(Book entity) throws Exception {
		DBCollection table = getDatabase().getCollection(Book.class.getSimpleName());
		BasicDBObject document = new BasicDBObject();
		ObjectId objectId = new ObjectId();
		document.put("id", objectId.getTime());
		document.put("name", entity.getName());
		Client client = entity.getClient();
		if (client == null) {
			document.put("client_id", null);
		} else {
			document.put("client_id", client.getId());
		}
		entity.setId(objectId.getTime());
		table.insert(document);
		return entity;
	}

	@Override
	public Book update(Book entity) throws Exception {
		DBCollection table = getDatabase().getCollection(Book.class.getSimpleName());

		BasicDBObject query = new BasicDBObject();
		query.put("id", entity.getId());

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("id", new ObjectId().getTime());
		newDocument.put("name", entity.getName());
		Client client = entity.getClient();
		if (client == null) {
			newDocument.put("client_id", null);
		} else {
			newDocument.put("client_id", client.getId());
		}

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

	@Override
	public List<Book> findAll() throws Exception {
		List<Book> books = null;
		DBCollection table = getDatabase().getCollection(Book.class.getSimpleName());

		DBCursor cursor = table.find();

		Book book = null;
		while (cursor.hasNext()) {
			DBObject result = cursor.next();
			book = new Book();
			book.setId((Long) result.get("id"));
			book.setName((String) result.get("name"));
			Long clientId = (Long) result.get("client_id");
			if (clientId != null) {
				Client client = new Client();
				client.setId(clientId);
				book.setClient(client);
			}
		}
		return books;
	}

	@Override
	public List<Book> findFreeBooks() throws Exception {
		List<Book> books = null;
		DBCollection table = getDatabase().getCollection(Book.class.getSimpleName());

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("client_id", null);

		DBCursor cursor = table.find(searchQuery);

		Book book = null;
		while (cursor.hasNext()) {
			DBObject result = cursor.next();
			book = new Book();
			book.setId((Long) result.get("id"));
			book.setName((String) result.get("name"));
		}
		return books;
	}

}
