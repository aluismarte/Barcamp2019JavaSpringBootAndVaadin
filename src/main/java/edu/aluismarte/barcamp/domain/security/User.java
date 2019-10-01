package edu.aluismarte.barcamp.domain.security;

import edu.aluismarte.barcamp.domain.AuditDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * Created by aluis on 9/30/19.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users")
public class User extends AuditDomain {

    @NotBlank
    @Column(length = 500, unique = true)
    private String username;

    @NotBlank
    @Column(length = 1000)
    private String password;

    @NotBlank
    @Column(length = 100)
    private String firstNames;

    @NotBlank
    @Column(length = 100)
    private String lastNames;

    @Column
    private LocalDate birthday;
}
