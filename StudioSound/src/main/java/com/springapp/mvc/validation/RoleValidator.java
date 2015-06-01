package com.springapp.mvc.validation;

import com.springapp.mvc.domain.Role;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RoleValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Role.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameRole", "required_nameRole", "Введите роль.");
    }
}

