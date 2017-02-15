package wsvintsitsky.instinctools.pattern.bridge;

public abstract class Service {

	private Action action;
	
	protected Service(Action action) {
		super();
		this.action = action;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	abstract void performAction();
}
