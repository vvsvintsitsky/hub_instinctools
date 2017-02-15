package wsvintsitsky.instinctools.pattern.decorator.facade;

public class RegistrationService implements IRegistrationServiceFacade {

	private Validator nameValidator;
	private Validator passwordValidator;
	
	public RegistrationService(Validator nameValidator, Validator passwordValidator) {
		super();
		this.nameValidator = nameValidator;
		this.passwordValidator = passwordValidator;
	}
	
	@Override
	public void register(String name, String password) {
		nameValidator.validate(name);
		passwordValidator.validate(password);
		System.out.println("base registration");
	}

}
