package com.hoangyth.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String> {
    private int min;
    private int max;

    @Override
    public void initialize(Name name) {
        this.min = name.min();
        this.max = name.max();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return name != null && !name.isEmpty() && name.length() <= this.max && name.length() >= this.min;
    }
}
