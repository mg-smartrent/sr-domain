package com.mg.smartrent.domain.models;

import com.mg.smartrent.domain.enums.EnCurrency;
import com.mg.smartrent.domain.enums.EnRentalApplicationStatus;
import com.mg.smartrent.domain.validation.annotations.PositiveDateRange;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PositiveDateRange(
        start = "checkInDate",
        end = "checkOutDate",
        message = "CheckIn Date should not be greater than CheckOut Date")
@FieldNameConstants
public class RentalApplication extends BizItem {

    @NotNull
    @Size(min = 1, max = MAX_FIELD_LENGTH)
    private String renterUserId;

    @NotNull
    @Size(min = 1, max = MAX_FIELD_LENGTH)
    private String propertyId;

    @Positive
    private Integer price;

    @NotNull
    private EnCurrency currency;

    @NotNull
    private Date checkInDate;

    @NotNull
    private Date checkOutDate;

    @NotNull
    private EnRentalApplicationStatus status;

}
