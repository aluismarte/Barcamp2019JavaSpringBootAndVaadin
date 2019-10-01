package edu.aluismarte.barcamp.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.templatemodel.TemplateModel;
import edu.aluismarte.barcamp.repository.UserRepository;
import edu.aluismarte.barcamp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Esto se hace con un componente polymer y se escribe en la demostración.
 * <p>
 * Created by aluis on 9/30/19.
 */
//@Tag("login-template")
//@HtmlImport("login/login-template.html")
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class Login extends VerticalLayout { // extends PolymerTemplate<Login.LoginModel>

    @Autowired
    private UserRepository userRepository;

    private LoginListener loginListener;

    public Login() {
        Constants.get().autoWiredClass(this);
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    private void fireLogin() {
        if (loginListener != null) {
            loginListener.login();
        }
    }

    public interface LoginListener {
        void login();
    }

    public interface LoginModel extends TemplateModel {
        // Elementos a usar para enviar al elemento
    }
}
