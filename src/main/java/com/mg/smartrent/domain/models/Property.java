package com.mg.smartrent.domain.models;

import com.mg.smartrent.domain.enums.EnBuildingType;
import com.mg.smartrent.domain.enums.EnPropertyCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@FieldNameConstants
public class Property extends BizItem {

    @NotNull
    @Size(min = 1, max = MAX_FIELD_LENGTH)
    private String userId;

    @NotNull
    private EnBuildingType buildingType = EnBuildingType.Unknown;

    @NotNull
    private EnPropertyCondition condition = EnPropertyCondition.Unknown;

    @PositiveOrZero
    private Integer totalRooms;

    @PositiveOrZero
    private Integer totalBathRooms;

    @PositiveOrZero
    private Integer totalBalconies;

    private byte[] thumbnail;
    private boolean parkingAvailable;

}
