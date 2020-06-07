package com.mg.samartrent.unit.models


import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.enums.EnGender
import com.mg.smartrent.domain.models.Renter

import static com.mg.samartrent.TestEntityBuilder.generateRenter

class RenterTest extends UnitTestSetup {

    def "test: test renter fields"() {
        given:
        Date date = new Date(10000000000)
        Renter renter = generateRenter()

        expect:
        renter.getId() == "11111"
        renter.getModifiedDate() == date
        renter.getCreatedDate() == date
        renter.getGender() == EnGender.Male
        renter.getLastName() == "LName"
        renter.getFirstName() == "FName"
        renter.getEmail() == "test.test@.domain.com"
        renter.getPhoneNumber() == "1131232131231"
        renter.getDateOfBirth() == date
    }


    def "test: renter equals"() {
        given:
        Renter renter1 = generateRenter()
        Renter renter2 = (Renter) renter1.clone()

        expect:
        Objects.equals(renter1, renter2)
    }

    def "test: renter hasCode"() {
        given:
        Renter renter1 = generateRenter()
        Renter renter2 = generateRenter()

        expect:
        renter1.hashCode() == renter2.hashCode()
    }


}
