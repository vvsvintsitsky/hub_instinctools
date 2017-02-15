package wsvintsitsky.instinctools.pattern.command;

public class CommandFactory {

	public ICommand defineCommand(String command) {
		ICommand current;
		if (command == null || command.isEmpty()) {
			return null;
		}
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(command.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			current = null;
		}
		return current;
	}
}
