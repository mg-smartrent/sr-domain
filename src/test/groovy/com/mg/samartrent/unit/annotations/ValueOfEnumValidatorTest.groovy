package com.mg.samartrent.unit.annotations

import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.enums.EnUserStatus
import com.mg.smartrent.domain.models.PropertyListing
import com.mg.smartrent.domain.models.User
import com.mg.smartrent.domain.validation.annotations.PositiveDateRange
import com.mg.smartrent.domain.validation.annotations.PositiveDateRangeValidator
import com.mg.smartrent.domain.validation.annotations.ValueOfEnum
import com.mg.smartrent.domain.validation.annotations.ValueOfEnumValidator

import javax.validation.ConstraintValidatorContext

class ValueOfEnumValidatorTest extends UnitTestSetup {

    private ConstraintValidatorContext constraintValidatorContext = Mock()
    private ValueOfEnum valueOfEnum = Mock()

    def "test: test value of enum validator"() {
        setup:
        ValueOfEnumValidator validator = new ValueOfEnumValidator()
        valueOfEnum.enumClass() >> EnUserStatus.class
        validator.initialize(valueOfEnum)

        when:
        def user = new User()
        user.setStatus(EnUserStatus.Active)

        then:
        validator.isValid('Active', constraintValidatorContext)
        !validator.isValid('InvalidEnum', constraintValidatorContext)

    }


}
