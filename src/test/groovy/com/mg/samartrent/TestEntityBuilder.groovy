package com.mg.samartrent


import com.mg.smartrent.domain.enums.EnBuildingType
import com.mg.smartrent.domain.enums.EnCurrency
import com.mg.smartrent.domain.enums.EnGender
import com.mg.smartrent.domain.enums.EnPropertyCondition
import com.mg.smartrent.domain.enums.EnRentalApplicationStatus
import com.mg.smartrent.domain.enums.EnUserStatus
import com.mg.smartrent.domain.models.Property
import com.mg.smartrent.domain.models.PropertyListing
import com.mg.smartrent.domain.models.RentalApplication
import com.mg.smartrent.domain.models.Renter
import com.mg.smartrent.domain.models.RenterReview
import com.mg.smartrent.domain.models.RenterView
import com.mg.smartrent.domain.models.User

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic

class TestEntityBuilder {

    final static Date defaultDate = new Date(10000000000)
    final static String longString = randomAlphabetic(1000)


    static User generateUser() {
        User user = new User()

        user.setFirstName("FName")
        user.setLastName("LName")
        user.setEmail("test.user@domain.com")
        user.setPassword("12341234")
        user.setGender(EnGender.Male)
        user.setDateOfBirth(defaultDate)
        user.setEnabled(true)
        user.setStatus(EnUserStatus.Active)
        user.setId("11111")
        user.setModifiedDate(defaultDate)
        user.setCreatedDate(defaultDate)

        return user
    }

    static Property generateProperty() {
        Property property = new Property()
        property.setId("11111")
        property.setModifiedDate(defaultDate)
        property.setCreatedDate(defaultDate)
        property.setBuildingType(EnBuildingType.Apartment)
        property.setCondition(EnPropertyCondition.Normal)
        property.setParkingAvailable(true)
        property.setThumbnail("test".bytes)
        property.setTotalBalconies(3)
        property.setTotalBathRooms(2)
        property.setTotalRooms(1)
        property.setUserId("12341234")

        return property
    }

    static PropertyListing generatePropertyListing() {
        PropertyListing listing = new PropertyListing()
        listing.setId("11111")
        listing.setModifiedDate(defaultDate)
        listing.setCreatedDate(defaultDate)
        listing.setUserId("12341234")
        listing.setPropertyId("2222")
        listing.setCheckInDate(defaultDate)
        listing.setCheckOutDate(defaultDate)
        listing.setListed(true)
        listing.setPrice(100)
        listing.setTotalViews(5)

        return listing
    }

    static RentalApplication generateRentalApplication() {
        RentalApplication rentalApplication = new RentalApplication()
        rentalApplication.setId("11111")
        rentalApplication.setModifiedDate(defaultDate)
        rentalApplication.setCreatedDate(defaultDate)
        rentalApplication.setPrice(100)
        rentalApplication.setCheckOutDate(defaultDate)
        rentalApplication.setCheckInDate(defaultDate)
        rentalApplication.setPropertyId("11111111")
        rentalApplication.setRenterUserId("333333")
        rentalApplication.setCurrency(EnCurrency.EUR)
        rentalApplication.setStatus(EnRentalApplicationStatus.PendingOwnerReview)

        return rentalApplication
    }

    static Renter generateRenter() {
        Renter renter = new Renter()
        renter.setId("11111")
        renter.setModifiedDate(defaultDate)
        renter.setCreatedDate(defaultDate)
        renter.setGender(EnGender.Male)
        renter.setLastName("LName")
        renter.setFirstName("FName")
        renter.setEmail("test.test@.domain.com")
        renter.setPhoneNumber("1131232131231")
        renter.setDateOfBirth(defaultDate)

        return renter
    }


    static RenterReview generateRenterReview() {
        RenterReview review = new RenterReview()
        review.setId("11111")
        review.setModifiedDate(defaultDate)
        review.setCreatedDate(defaultDate)
        review.setUserId("111112")
        review.setRating(4)
        review.setReview("test content")

        return review
    }

    static RenterView generateRenterView() {
        RenterView view = new RenterView()
        view.setId("11111")
        view.setModifiedDate(defaultDate)
        view.setCreatedDate(defaultDate)
        view.setUserId("111112")
        view.setRenterId("2222")

        return view
    }
}
