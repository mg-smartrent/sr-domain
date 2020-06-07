package com.mg.smartrent.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mg.smartrent.domain.enums.EnGender;
import com.mg.smartrent.domain.enums.EnUserStatus;
import io.leangen.graphql.annotations.GraphQLIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@FieldNameConstants
public class User extends BizItem {

    @NotNull
    @Size(min = 1, max = MAX_FIELD_LENGTH)
    private String firstName;

    @NotNull
    @Size(min = 1, max = MAX_FIELD_LENGTH)
    private String lastName;

    @NotNull
    @Past
    private Date dateOfBirth;

    @NotNull
    private EnGender gender = EnGender.Unknown;

    @NotNull
    @Email
    @Size(min = 1, max = MAX_FIELD_LENGTH)
    private String email;

    /**
     * Json annotations used to address security concerns.
     * - when MODEL converted in to JSON - password ignored
     * - when JSON is converted in to MODEL - password present
     */
    @NotNull
    @Size(min = 6, max = MAX_FIELD_LENGTH)
    @JsonIgnore
    @Getter(onMethod_ = {@JsonIgnore, @GraphQLIgnore})
    @Setter(onMethod_ = {
            @JsonProperty(access = JsonProperty.Access.READ_WRITE)})
    private String password;

    @NotNull
    private EnUserStatus status = EnUserStatus.Pending;

    private boolean enabled;


}
