package com.mg.samartrent.integration.models

import com.mg.samartrent.IntegrationTest
import com.mg.smartrent.domain.enrichment.ModelEnricher
import com.mg.smartrent.domain.models.User
import org.junit.experimental.categories.Category
import spock.lang.Specification

@Category(IntegrationTest.class)
class UserEnrichmentTest extends Specification {


    def "test: user default enrichment"() {
        when:
        User user = new User()

        then:
        user.getId() == null
        user.getCreatedDate() == null
        user.getModifiedDate() == null

        and:
        ModelEnricher.enrich(user)
        then:
        user.getId() == null
        user.getCreatedDate() != null
        user.getModifiedDate() != null

    }


}
