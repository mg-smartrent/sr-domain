package com.mg.smartrent.domain.validation.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements
        ConstraintValidator<PhoneNumber, String> {

    @Override
    public final boolean isValid(final String value,
                                 final ConstraintValidatorContext context) {
        return validatePhoneNumber(value);
    }


    private boolean validatePhoneNumber(final String phoneNo) {
        if (phoneNo == null) {
            return true;
        }
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) {
            return true;
        }
        //validating phone number with -, . or spaces
        if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
            return true;
        }
        //validating phone number with extension length from 3 to 5
        if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
            return true;
        }
        //validating phone number where area code is in braces ()
        return phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}");
    }
}
