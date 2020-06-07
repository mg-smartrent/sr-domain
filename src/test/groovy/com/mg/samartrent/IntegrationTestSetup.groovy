package com.mg.samartrent


import com.mg.smartrent.domain.models.BizItem
import com.mg.smartrent.domain.validation.ModelValidator
import org.junit.experimental.categories.Category
import org.springframework.beans.BeanWrapperImpl
import spock.lang.Specification

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

@Category(IntegrationTest.class)
class IntegrationTestSetup extends Specification {

    void validateModel(BizItem model,
                       String fieldName,
                       Object fieldValue,
                       Object expectedValue,
                       boolean expectException,
                       boolean checkExcMsgContains,
                       String exceptionMsg) {

        new BeanWrapperImpl(model).setPropertyValue(fieldName, fieldValue)
        try {
            ModelValidator.validate(model)//run validation rules

            BeanWrapperImpl beanUtilsWrapper = new BeanWrapperImpl(model)
            assertEquals(expectedValue, beanUtilsWrapper.getPropertyValue(fieldName))
            assertEquals(expectException, false)

        } catch (Exception e) {
            if (!checkExcMsgContains) {
                assertEquals(exceptionMsg, e.getMessage().trim())
            } else {
                def explanation = "ACTUAL: ${e.getMessage().trim()}\nShould countain\nEXPECTED: $exceptionMsg"
                assertTrue(explanation, e.getMessage().trim().contains(exceptionMsg))
            }
        }
    }
}
