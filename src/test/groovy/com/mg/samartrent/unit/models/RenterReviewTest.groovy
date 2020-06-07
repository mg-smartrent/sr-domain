package com.mg.samartrent.unit.models

import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.models.RenterReview

import static com.mg.samartrent.TestEntityBuilder.generateRenterReview

class RenterReviewTest extends UnitTestSetup {

    def "test: test renter review fields"() {
        given:
        Date date = new Date(10000000000)
        RenterReview review = generateRenterReview()

        expect:
        review.getId() == "11111"
        review.getModifiedDate() == date
        review.getCreatedDate() == date
        review.getUserId() == "111112"
        review.getRating() == 4
        review.getReview() == "test content"
    }


    def "test: renter review equals"() {
        given:
        RenterReview review1 = generateRenterReview()
        RenterReview review2 = (RenterReview) review1.clone()

        expect:
        Objects.equals(review1, review2)
    }

    def "test: renter hasCode"() {
        given:
        RenterReview review1 = generateRenterReview()
        RenterReview review2 = generateRenterReview()

        expect:
        review1.hashCode() == review2.hashCode()
    }


}
