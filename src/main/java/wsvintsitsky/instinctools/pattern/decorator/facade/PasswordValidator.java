package wsvintsitsky.instinctools.pattern.decorator.facade;

public class PasswordValidator implements Validator {

	@Override
	public boolean validate(String toValidate) {
		return true;
	}

}
