package wsvintsitsky.instinctools.sqlnosql.dataaccess.jdbc.impl;

import javax.sql.DataSource;

import wsvintsitsky.instinctools.sqlnosql.dataaccess.AbstractDao;

public abstract class AbstractDaoImpl<T, ID> implements AbstractDao<T, ID> {

	private DataSource dataSource;
	
	public AbstractDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
