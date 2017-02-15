package wsvintsitsky.instinctools.pattern.bridge;

public class ClientService extends Service {
	
	public ClientService(Action action) {
		super(action);
	}

	@Override
	public void performAction() {
		System.out.println("performing action");
		getAction().execute();
	}

}
