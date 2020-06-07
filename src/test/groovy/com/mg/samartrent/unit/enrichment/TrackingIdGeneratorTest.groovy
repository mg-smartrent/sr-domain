package com.mg.samartrent.unit.enrichment


import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.enrichment.TrackingIdGenerator
import com.mg.smartrent.domain.enums.EnBuildingType
import com.mg.smartrent.domain.enums.EnPropertyCondition
import com.mg.smartrent.domain.models.Property

import static com.mg.samartrent.TestEntityBuilder.generateProperty

class TrackingIdGeneratorTest extends UnitTestSetup {

    def "test: test property fields"() {
        expect:
        TrackingIdGenerator.generateUnique() != null
    }

}
