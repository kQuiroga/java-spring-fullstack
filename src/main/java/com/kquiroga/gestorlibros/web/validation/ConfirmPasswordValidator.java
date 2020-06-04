package com.kquiroga.gestorlibros.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.kquiroga.gestorlibros.web.model.UserForm;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmacionPassword, Object> {

    
    @Override
    public void initialize(final ConfirmacionPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final Object valor, final ConstraintValidatorContext context) {
        final UserForm userForm = (UserForm) valor;
        return userForm.getPassword().equals(userForm.getConfirmacionPassword());
    }
}
