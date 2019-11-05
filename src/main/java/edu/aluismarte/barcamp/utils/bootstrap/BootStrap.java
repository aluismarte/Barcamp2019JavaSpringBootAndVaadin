package edu.aluismarte.barcamp.utils.bootstrap;

import edu.aluismarte.barcamp.domain.security.Param;
import edu.aluismarte.barcamp.domain.security.User;
import edu.aluismarte.barcamp.model.ParamValueType;
import edu.aluismarte.barcamp.repository.ParamRepository;
import edu.aluismarte.barcamp.repository.UserRepository;
import edu.aluismarte.barcamp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

/**
 * Created by aluis on 9/30/19.
 */
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class BootStrap {

    @Autowired
    private ParamRepository paramRepository;
    @Autowired
    private UserRepository userRepository;

    public BootStrap() {
        Constants.get().autoWiredClass(this);
    }

    public void init() {
        createParam(1, ParamValueType.TEXT, "Follow Me", "", "Sigueme en Instagram, youtube y Github!");
        createParam(2, ParamValueType.NUMERIC, "Ajuste", "Test para dato numerico", "10.00");

        create("aluis", "123456", "Aluis", "Marte", LocalDate.of(1990, 7, 25));
    }

    public void destroy() {
    }

    private Param createParam(Integer code, ParamValueType paramValueType, String name, String description, String value) {
        Param param = paramRepository.findByCode(code);
        if (param == null) {
            param = new Param();
            param.setCode(code);
            param.setParamValueType(paramValueType);
            param.setName(name);
            param.setDescription(description);
            param.setValue(value);
            return paramRepository.saveAndFlush(param);
        }
        return param;
    }

    private User create(String username, String password, String firstNames, String lastNames, LocalDate birthday) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFirstNames(firstNames);
            user.setLastNames(lastNames);
            user.setBirthday(birthday);
            return userRepository.saveAndFlush(user);
        }
        return user;
    }
}
