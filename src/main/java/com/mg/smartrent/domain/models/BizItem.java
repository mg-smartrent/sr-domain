package com.mg.smartrent.domain.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
@NoArgsConstructor
@FieldNameConstants
public abstract class BizItem implements Cloneable {

    protected static final int MAX_FIELD_LENGTH = 100;
    private String id;

    @NotNull
    @PastOrPresent
    private Date createdDate;

    @NotNull
    private Date modifiedDate;
}
