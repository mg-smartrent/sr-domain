package com.mg.samartrent.unit.annotations

import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.models.PropertyListing
import com.mg.smartrent.domain.validation.annotations.PositiveDateRange
import com.mg.smartrent.domain.validation.annotations.PositiveDateRangeValidator

import javax.validation.ConstraintValidatorContext

class PositiveDateRangeValidatorTest extends UnitTestSetup {

    private ConstraintValidatorContext constraintValidatorContext = Mock()
    private PositiveDateRange positiveDateRange = Mock()

    def "test: test positive date range validator"() {
        setup:
        PositiveDateRangeValidator validator = new PositiveDateRangeValidator()
        positiveDateRange.start() >> 'checkInDate'
        positiveDateRange.end() >> 'checkOutDate'
        validator.initialize(positiveDateRange)

        when: "positive range"
        def listing = new PropertyListing()
        listing.setCheckInDate(new Date(1000000))
        listing.setCheckOutDate(new Date(1001111))

        then:
        validator.isValid(listing, constraintValidatorContext)

        when: "negative range"
        listing.setCheckInDate(new Date(1001111))
        listing.setCheckOutDate(new Date(1000000))

        then:
        !validator.isValid(listing, constraintValidatorContext)
    }


}
