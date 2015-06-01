package com.springapp.mvc.validation;

import com.springapp.mvc.domain.Actor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ActorValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Actor.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "required_surname", "Введите фамилию.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required_name", "Введите имя.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "required_lastname", "Введите отчество.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "required_dateOfBirth", "Введите дату рождения.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experience", "required_experience", "Введите стаж.");
    }
}
