package edu.aluismarte.barcamp.utils.bootstrap;

import edu.aluismarte.barcamp.domain.security.Param;
import edu.aluismarte.barcamp.model.ParamValueType;
import edu.aluismarte.barcamp.repository.ParamRepository;
import edu.aluismarte.barcamp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aluis on 9/30/19.
 */
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class BootStrap {

    @Autowired
    private ParamRepository paramRepository;

    public BootStrap() {
        Constants.get().autoWiredClass(this);
    }

    public void init() {
        createParam(1, ParamValueType.TEXT, "Follow Me", "", "Sigueme en Instagram, youtube y Github!");
        createParam(2, ParamValueType.NUMERIC, "Ajuste", "Test para dato numerico", "10.00");
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
}
