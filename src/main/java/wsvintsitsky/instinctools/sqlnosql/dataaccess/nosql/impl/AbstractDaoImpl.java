package wsvintsitsky.instinctools.sqlnosql.dataaccess.nosql.impl;

import com.mongodb.DB;

import wsvintsitsky.instinctools.sqlnosql.dataaccess.AbstractDao;

public abstract class AbstractDaoImpl<T, ID> implements AbstractDao<T, ID> {

	private DB database;

	public AbstractDaoImpl(DB database) {
		super();
		this.database = database;
	}

	protected DB getDatabase() {
		return database;
	}

	protected void setDatabase(DB database) {
		this.database = database;
	}
}
