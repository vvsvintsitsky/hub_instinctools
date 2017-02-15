package wsvintsitsky.instinctools.pattern.decorator.facade;

public class PremiumRegistrationService extends RegistrationServiceDecorator {

	public PremiumRegistrationService(RegistrationService registrationService) {
		super(registrationService);
	}

	@Override
	public void register(String name, String password) {
		super.register(name, password);
		System.out.println("premium registration");
	}
}
