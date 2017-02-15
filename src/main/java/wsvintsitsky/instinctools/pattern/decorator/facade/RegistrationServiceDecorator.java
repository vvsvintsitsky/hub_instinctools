package wsvintsitsky.instinctools.pattern.decorator.facade;

public class RegistrationServiceDecorator implements IRegistrationServiceFacade {

	protected RegistrationService registrationService;
	
	public RegistrationServiceDecorator(RegistrationService registrationService) {
		super();
		this.registrationService = registrationService;
	}

	@Override
	public void register(String name, String password) {
		registrationService.register(name, password);
		System.out.println("decorated base registration");
	}

}
