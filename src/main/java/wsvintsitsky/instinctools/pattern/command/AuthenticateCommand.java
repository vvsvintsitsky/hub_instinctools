package wsvintsitsky.instinctools.pattern.command;

public class AuthenticateCommand implements ICommand {

	@Override
	public void execute() {
		System.out.println("authenticating");
	}
}
