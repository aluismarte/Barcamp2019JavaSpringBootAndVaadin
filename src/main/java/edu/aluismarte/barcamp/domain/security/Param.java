package edu.aluismarte.barcamp.domain.security;

import edu.aluismarte.barcamp.domain.AuditDomain;
import edu.aluismarte.barcamp.model.ParamValueType;
import edu.aluismarte.barcamp.model.converter.ParamValueTypeConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Created by aluis on 9/30/19.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "params")
public class Param extends AuditDomain {

    @Column
    private int code;

    @Convert(converter = ParamValueTypeConverter.class) // Metodo ultra eficiente para los enums
    @Column(nullable = false)
    private ParamValueType paramValueType;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String value;

    @Override
    public String toString() {
        if (name != null) {
            return String.format("%s %s", code, name);
        }
        return super.toString();
    }
}
