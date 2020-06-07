package com.mg.samartrent.unit.models

import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.enums.EnCurrency
import com.mg.smartrent.domain.enums.EnRentalApplicationStatus
import com.mg.smartrent.domain.models.RentalApplication

import static com.mg.samartrent.TestEntityBuilder.generateRentalApplication

class RentalApplicationTest extends UnitTestSetup {

    def "test: test rental application fields"() {
        given:
        Date date = new Date(10000000000)
        RentalApplication rentalApplication = generateRentalApplication()

        expect:
        rentalApplication.getId() == "11111"
        rentalApplication.getModifiedDate() == date
        rentalApplication.getCreatedDate() == date
        rentalApplication.getPrice() == 100
        rentalApplication.getCheckOutDate() == date
        rentalApplication.getCheckInDate() == date
        rentalApplication.getPropertyId() == "11111111"
        rentalApplication.getRenterUserId() == "333333"
        rentalApplication.getCurrency() == EnCurrency.EUR
        rentalApplication.getStatus() == EnRentalApplicationStatus.PendingOwnerReview

    }


    def "test: rental application equals"() {
        given:
        RentalApplication rentalApplication1 = generateRentalApplication()
        RentalApplication rentalApplication2 = (RentalApplication) rentalApplication1.clone()
        expect:
        Objects.equals(rentalApplication1, rentalApplication2)
    }

    def "test: rental application hasCode"() {
        given:
        RentalApplication rentalApplication1 = generateRentalApplication()
        RentalApplication rentalApplication2 = generateRentalApplication()

        expect:
        rentalApplication1.hashCode() == rentalApplication2.hashCode()
    }


}
