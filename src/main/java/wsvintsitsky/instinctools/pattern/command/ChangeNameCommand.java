package wsvintsitsky.instinctools.pattern.command;

public class ChangeNameCommand implements ICommand {

	@Override
	public void execute() {
		System.out.println("changing name");
	}
}
