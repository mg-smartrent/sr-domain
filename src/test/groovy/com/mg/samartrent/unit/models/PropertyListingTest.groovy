package com.mg.samartrent.unit.models


import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.models.PropertyListing

import static com.mg.samartrent.TestEntityBuilder.generatePropertyListing

class PropertyListingTest extends UnitTestSetup {

    def "test: test property listing fields"() {
        given:
        Date date = new Date(10000000000)
        PropertyListing listing = generatePropertyListing()

        expect:
        listing.getId() == "11111"
        listing.getUserId() == "12341234"
        listing.getModifiedDate() == date
        listing.getCreatedDate() == date
        listing.getPropertyId() == "2222"
        listing.getCheckInDate() == date
        listing.getCheckOutDate() == date
        listing.isListed()
        listing.getPrice() == 100
        listing.getTotalViews() == 5
    }


    def "test: property listing equals"() {
        given:
        PropertyListing listing1 = generatePropertyListing()
        PropertyListing listing2 = (PropertyListing) listing1.clone()

        expect:
        Objects.equals(listing1, listing2)
    }

    def "test: property listing hasCode"() {
        given:
        PropertyListing listing1 = generatePropertyListing()
        PropertyListing listing2 = (PropertyListing) listing1.clone()

        expect:
        listing1.hashCode() == listing2.hashCode()
    }


}
