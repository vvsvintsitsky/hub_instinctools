package wsvintsitsky.instinctools.sqlnosql.exception;

public class SingletonException extends Exception {

	private static final long serialVersionUID = 1L;

	public SingletonException() {

	}

	public SingletonException(String error) {
		super(error);
	}
}
