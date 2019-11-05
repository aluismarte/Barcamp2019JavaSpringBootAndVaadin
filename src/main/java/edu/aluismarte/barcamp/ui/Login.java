package edu.aluismarte.barcamp.ui;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import edu.aluismarte.barcamp.domain.security.User;
import edu.aluismarte.barcamp.model.LoginSession;
import edu.aluismarte.barcamp.repository.UserRepository;
import edu.aluismarte.barcamp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * Esto se hace con un componente polymer y se escribe en la demostración.
 * <p>
 * Created by aluis on 9/30/19.
 */
//@Tag("login-template")
//@HtmlImport("login/login-template.html")
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class Login extends Dialog { // extends PolymerTemplate<Login.LoginModel>

    // Adicionar la versión flotante en el login para mostrar como se pasan los parámetros

    @Autowired
    private UserRepository userRepository; // No hagan esto, es una demostración, deben crear los servicios y hacer una instancia.

//    @Id("user_login")
//    private Input user;
//    @Id("password_login")
//    private Input password;

    private LoginListener loginListener;

    public Login() {
        setWidth("400px");
        setHeight("400px");
        Constants.get().autoWiredClass(this);
        add(new Label("Hola Vaadin con el login"));
    }

//    @EventHandler
//    private void loginClick() {
//        User user = userRepository.findByUsernameAndPasswordAndEnabledIsTrue(this.user.getValue(), password.getValue());
//        if (user != null) {
//            LoginSession loginSession = new LoginSession();
//            loginSession.setUser(user);
//            getUI().ifPresent(ui -> ui.getSession().setAttribute(LoginSession.class, loginSession));
//            fireLogin();
//        } else {
//            Notification.show("Error, user and password no found", 10 * 1000, Notification.Position.MIDDLE);
//        }
//    }

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
