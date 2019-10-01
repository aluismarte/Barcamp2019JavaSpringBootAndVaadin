package edu.aluismarte.barcamp.utils.configuration;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.Command;
import com.vaadin.flow.server.VaadinSession;
import edu.aluismarte.barcamp.model.LoginSession;
import edu.aluismarte.barcamp.utils.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Permite auditar a los usuarios sin necesidad de escribir nada mas que una simple configuración y saber quien crea los objetos.
 * <p>
 * Created by aluis on 9/30/19.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SpringAuditingConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            VaadinSession current = VaadinSession.getCurrent();
            if (current != null) {
                AtomicReference<String> username = new AtomicReference<>(Constants.SYSTEM);
                UI.getCurrent().accessSynchronously((Command) () -> {
                    LoginSession loginSession = current.getAttribute(LoginSession.class);
                    if (loginSession != null) {
                        username.set(loginSession.getUser().getUsername());
                    }
                });
                return Optional.ofNullable(username.get());
            }
            return Optional.of(Constants.SYSTEM);
        };
    }
}
