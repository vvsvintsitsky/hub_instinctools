package wsvintsitsky.instinctools.pattern.command;

public class ProcessInputCommand implements ICommand {

	@Override
	public void execute() {
		System.out.println("processing input");
	}
}
