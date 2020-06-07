package com.mg.smartrent.domain.models;


import com.mg.smartrent.domain.enums.EnGender;
import com.mg.smartrent.domain.validation.annotations.PhoneNumber;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class Renter extends BizItem {

    @NotNull
    @Size(min = 1, max = MAX_FIELD_LENGTH)
    private String firstName;

    @NotNull
    @Size(min = 1, max = MAX_FIELD_LENGTH)
    private String lastName;

    @Past
    private Date dateOfBirth;

    @NotNull
    @Email
    @Size(min = 1, max = MAX_FIELD_LENGTH)
    private String email;

    @Size(min = 1, max = MAX_FIELD_LENGTH)
    @PhoneNumber
    private String phoneNumber;

    @NotNull
    private EnGender gender = EnGender.Unknown;

}
