package edu.aluismarte.barcamp.model;

import edu.aluismarte.barcamp.domain.security.User;
import lombok.Data;

/**
 * Created by aluis on 9/30/19.
 */
@Data
public class LoginSession {

    private User user;
}
