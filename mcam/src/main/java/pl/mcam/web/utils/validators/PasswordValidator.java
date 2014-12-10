package pl.mcam.web.utils.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.mcam.web.utils.Registration;
import pl.mcam.web.validators.IPasswordCorfirmation;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof IPasswordCorfirmation) {			
			final IPasswordCorfirmation credential = (IPasswordCorfirmation)target;
			final String password = credential.getPassword();
			final String vpassword = credential.getVpassword();
			if (password != null && vpassword != null) {
				if (!password.equals(vpassword)) {
					errors.rejectValue("vpassword", "form.passwords.NotMatch");
				}
			}
		}
	}
}
