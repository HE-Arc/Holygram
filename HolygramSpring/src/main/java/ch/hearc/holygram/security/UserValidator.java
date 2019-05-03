package ch.hearc.holygram.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.hearc.holygram.forms.UserForm;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.services.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		UserForm userForm = (UserForm) o;

		final String u = "username";

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, u, "NotEmpty", "The username can't be empty");
		if (userForm.getUsername().length() < 6 || userForm.getUsername().length() > 32) {
			errors.rejectValue(u, "Size.userForm.username", "The username must be between 6 and 32 characters");
		}

		if (userService.findByUsername(userForm.getUsername()) != null) {
			errors.rejectValue(u, "Duplicate.userForm.username", "The username already exists");
		}

		if (userService.findByEmail(userForm.getEmail()) != null) {
			errors.rejectValue("email", "Duplicate.userForm.email", "The email already exists");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty", "The password can't be empty");
		if (userForm.getPassword().length() < 8 || userForm.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password",
					"The password must be between 8 and 32 characters");
		}

		if (!userForm.getPasswordConfirm().equals(userForm.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm",
					"The confirmation password isn't the same as password");
		}
	}
}