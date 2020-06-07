package com.mg.samartrent.unit.annotations

import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.validation.annotations.PhoneNumberValidator

import javax.validation.ConstraintValidatorContext

class PhoneNumberValidatorTest extends UnitTestSetup {

    private ConstraintValidatorContext constraintValidatorContext = Mock()

    def "test: test phone number validator"() {
        when:
        PhoneNumberValidator validator = new PhoneNumberValidator()
        then:
        validator.isValid("1234567890", constraintValidatorContext)
        !validator.isValid("A234567890", constraintValidatorContext)
        !validator.isValid("@234567890", constraintValidatorContext)
        !validator.isValid("aaaaaaaaaa", constraintValidatorContext)
    }


}
