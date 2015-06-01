package com.springapp.mvc.validation;

import com.springapp.mvc.domain.Project;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProjectValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Project.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "required_year", "Введите год выпуска.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameProject", "required_nameProject", "Введите название.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "required_country", "Введите страну.");
    }
}
