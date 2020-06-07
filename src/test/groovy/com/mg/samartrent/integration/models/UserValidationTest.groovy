package com.mg.samartrent.integration.models

import com.mg.samartrent.IntegrationTestSetup
import com.mg.samartrent.TestEntityBuilder
import com.mg.smartrent.domain.enums.EnGender
import com.mg.smartrent.domain.enums.EnUserStatus
import spock.lang.Unroll

import static com.mg.samartrent.TestEntityBuilder.*
import static com.mg.samartrent.TestEntityBuilder.*

class UserValidationTest extends IntegrationTestSetup {


    @Unroll
    def "test: user constraints for #FIELD = #TEST_VALUE"() {
        given: "a model and a value - validation passed"
        validateModel(MODEL, FIELD, TEST_VALUE, EXPECTED_VALUE, EXPECT_EXCEPTION, CHECK_ERROR_CONTAINS, ERROR_MSG)

        where: 'test data is:'
        MODEL          | FIELD         | TEST_VALUE           | EXPECTED_VALUE       | EXPECT_EXCEPTION | CHECK_ERROR_CONTAINS | ERROR_MSG
        generateUser() | 'firstName'   | null                 | null                 | true             | false                | 'Field "firstName" has an invalid value "null". [may not be null]'
        generateUser() | 'firstName'   | ""                   | null                 | true             | false                | 'Field "firstName" has an invalid value "". [size must be between 1 and 100]'
        generateUser() | 'firstName'   | longString           | null                 | true             | true                 | '[size must be between 1 and 100]'
        generateUser() | 'firstName'   | "FName"              | "FName"              | false            | false                | null

        generateUser() | 'lastName'    | null                 | null                 | true             | false                | 'Field "lastName" has an invalid value "null". [may not be null]'
        generateUser() | 'lastName'    | ""                   | null                 | true             | false                | 'Field "lastName" has an invalid value "". [size must be between 1 and 100]'
        generateUser() | 'lastName'    | longString           | null                 | true             | true                 | '[size must be between 1 and 100]'
        generateUser() | 'lastName'    | "LName"              | "LName"              | false            | false                | null

        generateUser() | 'email'       | null                 | null                 | true             | false                | 'Field "email" has an invalid value "null". [may not be null]'
        generateUser() | 'email'       | ""                   | null                 | true             | false                | 'Field "email" has an invalid value "". [size must be between 1 and 100]'
        generateUser() | 'email'       | longString           | null                 | true             | true                 | '[size must be between 1 and 100]'
        generateUser() | 'email'       | "test.test@test.com" | "test.test@test.com" | false            | false                | null

        generateUser() | 'dateOfBirth' | defaultDate          | defaultDate          | false            | false                | null
        generateUser() | 'dateOfBirth' | null                 | null                 | true             | false                | 'Field "dateOfBirth" has an invalid value "null". [may not be null]'

        generateUser() | 'gender'      | null                 | EnGender.Unknown     | true             | false                | 'Field "gender" has an invalid value "null". [may not be null]'
        generateUser() | 'gender'      | ""                   | null                 | true             | false                | 'Field "gender" has an invalid value "null". [may not be null]'
        generateUser() | 'gender'      | EnGender.Male        | EnGender.Male        | false            | false                | null
        generateUser() | 'gender'      | EnGender.Female      | EnGender.Female      | false            | false                | null
        generateUser() | 'gender'      | EnGender.Unknown     | EnGender.Unknown     | false            | false                | null

        generateUser() | 'password'    | null                 | null                 | true             | false                | 'Field "password" has an invalid value "null". [may not be null]'
        generateUser() | 'password'    | ""                   | null                 | true             | false                | 'Field "password" has an invalid value "". [size must be between 6 and 100]'

        generateUser() | 'status'      | EnUserStatus.Active  | EnUserStatus.Active  | false            | false                | null
        generateUser() | 'status'      | EnUserStatus.Pending | EnUserStatus.Pending | false            | false                | null
        generateUser() | 'status'      | null                 | EnUserStatus.Pending | true             | false                | 'Field "status" has an invalid value "null". [may not be null]'
        generateUser() | 'status'      | ""                   | EnUserStatus.Pending | true             | false                | 'Field "status" has an invalid value "null". [may not be null]'

        generateUser() | 'enabled'     | false                | false                | false            | false                | null
        generateUser() | 'enabled'     | true                 | true                 | false            | false                | null
    }


}
