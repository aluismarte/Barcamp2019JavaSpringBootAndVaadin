package edu.aluismarte.barcamp.model.converter;

import edu.aluismarte.barcamp.model.ParamValueType;

import javax.persistence.AttributeConverter;

/**
 * Forma eficiente de trabajar los enums en la DB
 * <p>
 * Created by aluis on 9/30/19.
 */
public class ParamValueTypeConverter implements AttributeConverter<ParamValueType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ParamValueType attribute) {
        if (attribute == null) {
            return null;
        }
        switch (attribute) {
            case BOOLEAN:
                return 1;
            case TEXT:
                return 2;
            case NUMERIC:
                return 3;
            default:
                return null;
        }
    }

    @Override
    public ParamValueType convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        switch (dbData) {
            case 1:
                return ParamValueType.BOOLEAN;
            case 2:
                return ParamValueType.TEXT;
            case 3:
                return ParamValueType.NUMERIC;
            default:
                return null;
        }
    }
}
