package com.mg.smartrent.domain.validation.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Date;


public final class PositiveDateRangeValidator implements
        ConstraintValidator<PositiveDateRange, Object> {

    private String start;
    private String end;

    @Override
    public void initialize(final PositiveDateRange constraint) {
        start = constraint.start();
        end = constraint.end();
    }

    @Override
    public boolean isValid(final Object object,
                           final ConstraintValidatorContext context) {
        try {
            Date startDate = (Date) getFieldValue(object, start);
            Date endDate = (Date) getFieldValue(object, end);

            if ((startDate == null && endDate != null) || (startDate != null && endDate == null)) {
                return false;
            }
            //if both are null then consider as valid case
            if (startDate == null && endDate == null) {
                return true;
            }
            return startDate.before(endDate) || startDate.equals(endDate);

        } catch (Exception e) {
            return false;
        }
    }

    private Object getFieldValue(final Object object, final String fieldName) throws Exception {
        Class<?> clazz = object.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

}
