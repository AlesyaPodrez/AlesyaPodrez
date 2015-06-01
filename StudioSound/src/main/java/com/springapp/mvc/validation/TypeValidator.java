package com.springapp.mvc.validation;

import com.springapp.mvc.domain.myType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TypeValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return myType.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameType", "required_nameType", "Введите тип.");
    }
}
