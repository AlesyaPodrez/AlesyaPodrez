package com.springapp.mvc.validation;

import com.springapp.mvc.domain.Staff;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StaffValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Staff.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idType", "required_idType", "Выберите тип.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "required_surname", "Введите фамилию.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required_name", "Введите имя.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "required_lastname", "Введите отчество.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "required_dateOfBirth", "Введите дату рождения.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experience", "required_experience", "Введите стаж.");
    }
}
