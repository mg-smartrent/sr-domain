package com.mg.samartrent.unit.models

import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.models.RenterView

import static com.mg.samartrent.TestEntityBuilder.generateRenterView

class RenterViewTest extends UnitTestSetup {

    def "test: test renter view fields"() {
        given:
        Date date = new Date(10000000000)
        RenterView view = generateRenterView()

        expect:
        view.getId() == "11111"
        view.getModifiedDate() == date
        view.getCreatedDate() == date
        view.getUserId() == "111112"
        view.getRenterId() == "2222"
    }


    def "test: renter view equals"() {
        given:
        RenterView view1 = generateRenterView()
        RenterView view2 = (RenterView) view1.clone()

        expect:
        Objects.equals(view1, view2)
    }

    def "test: renter view hasCode"() {
        given:
        RenterView view1 = generateRenterView()
        RenterView view2 = generateRenterView()

        expect:
        view1.hashCode() == view2.hashCode()
    }


}
