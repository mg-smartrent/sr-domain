package com.mg.samartrent.unit.models

import com.fasterxml.jackson.databind.ObjectMapper
import com.mg.samartrent.UnitTestSetup
import com.mg.smartrent.domain.enums.EnGender
import com.mg.smartrent.domain.enums.EnUserStatus
import com.mg.smartrent.domain.models.User
import com.mg.smartrent.domain.validation.ModelBusinessValidationException

import static com.mg.samartrent.TestEntityBuilder.generateUser


class UserTest extends UnitTestSetup {

    static ObjectMapper mapper = new ObjectMapper();

    def "test: password present on Deserialization"() {
        setup:
        String json = """{ "password":"12341234",
                           "id":null,
                           "createdDate":null,
                           "modifiedDate":null,
                           "firstName":"FName",
                           "lastName":"LName",
                           "dateOfBirth":100000000000,
                           "gender":"Male",
                           "email":"asda.user@domain.com",
                           "status":"Active",
                           "enabled":true 
                          }""";
        when:
        User model = mapper.readValue(json, User.class);
        then:
        "12341234" == model.getPassword()
    }

    def "test: password missing on Serialization"() {
        when:
        String jsonString = mapper.writeValueAsString(generateUser());

        then:
        !jsonString.contains("password")
        !jsonString.contains("\"password\":\"12341234\"");
    }

    def "test: test user fields"() {
        given:
        Date date = new Date(10000000000)
        User user = generateUser()

        expect:
        user.getDateOfBirth() == date
        user.getModifiedDate() == date
        user.getCreatedDate() == date
        user.getEmail() == "test.user@domain.com"
        user.isEnabled()
        user.getFirstName() == "FName"
        user.getLastName() == "LName"
        user.getGender() == EnGender.Male
        user.getPassword() == "12341234"
        user.getStatus() == EnUserStatus.Active
        user.getId() == "11111"
    }


    def "test: user equals"() {
        given:
        User user1 = generateUser()
        User user2 = (User) user1.clone()

        expect:
        user1.equals(user2)
    }

    def "test: user hasCode"() {
        given:
        User user1 = generateUser()
        User user2 = generateUser()

        expect:
        user1.hashCode() == user2.hashCode()
    }

    def "test: business validation exception"() {
        when:
        throw new ModelBusinessValidationException("Ops!")

        then:
        Exception e = thrown(ModelBusinessValidationException)
        e.getMessage() == "Ops!"
    }


}
