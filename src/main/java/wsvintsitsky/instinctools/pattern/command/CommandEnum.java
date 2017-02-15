package wsvintsitsky.instinctools.pattern.command;

public enum CommandEnum {

	PROCESS_INPUT {
		{
			this.command = new ProcessInputCommand();
		}
	},
	AUTHENTICATE {
		{
			this.command = new AuthenticateCommand();
		}
	},
	CHANGE_NAME {
		{
			this.command = new ChangeNameCommand();
		}
	};

	ICommand command;

	public ICommand getCurrentCommand() {
		return command;
	}
}
