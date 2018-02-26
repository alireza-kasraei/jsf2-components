package net.devk.core.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class NationalCodeValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String nationalCode = value.toString();
		if (nationalCode.length() != 10) {
			FacesMessage facesMessage = new FacesMessage("national code length should be 10");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(facesMessage);
		}
		Integer controlDigit = Integer.valueOf(nationalCode.substring(9));
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += Integer.valueOf(nationalCode.substring(i, i + 1)) * (10 - i);
		}
		int rValue = sum % 11;

		if (rValue < 2) {
			if (controlDigit.intValue() != rValue) {
				FacesMessage facesMessage = createInvalidNationalCodeException();
				throw new ValidatorException(facesMessage);
			}
		} else {
			if (controlDigit.intValue() != (11 - rValue)) {
				FacesMessage facesMessage = createInvalidNationalCodeException();
				throw new ValidatorException(facesMessage);
			}
		}

	}

	private FacesMessage createInvalidNationalCodeException() {
		FacesMessage facesMessage = new FacesMessage("invalid national code.");
		facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		return facesMessage;
	}

}
