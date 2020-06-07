package com.mg.samartrent.unit.models


import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.enums.EnBuildingType
import com.mg.smartrent.domain.enums.EnPropertyCondition
import com.mg.smartrent.domain.models.Property

import static com.mg.samartrent.TestEntityBuilder.generateProperty

class PropertyTest extends UnitTestSetup {

    def "test: test property fields"() {
        given:
        Date date = new Date(10000000000)
        Property property = generateProperty()

        expect:
        property.getId() == "11111"
        property.getModifiedDate() == date
        property.getCreatedDate() == date
        property.getBuildingType() == EnBuildingType.Apartment
        property.getThumbnail() == "test".bytes
        property.getCondition() == EnPropertyCondition.Normal
        property.getTotalBalconies() == 3
        property.getTotalBathRooms() == 2
        property.getTotalRooms() == 1
        property.getUserId() == "12341234"
    }


    def "test: property equals"() {
        given:
        Property property1 = generateProperty()
        Property property2 = (Property) property1.clone()

        expect:
        Objects.equals(property1, property2)
    }

    def "test: property hasCode"() {
        given:
        Property property1 = generateProperty()
        Property property2 = generateProperty()

        expect:
        property1.hashCode() == property2.hashCode()
    }


}
