package it.uniroma3.siw.progettoSIW.services;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.progettoSIW.model.Foto;

@Component 
public class FotoValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return Foto.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "fotografo", "required");
		

	}
}