package edu.aluismarte.barcamp;

import edu.aluismarte.barcamp.utils.Constants;
import edu.aluismarte.barcamp.utils.bootstrap.BootStrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.annotation.WebServlet;

/**
 * Created by aluis on 9/30/19.
 */
@WebServlet
@EnableTransactionManagement
@SpringBootApplication
public class JavaSpringBootVaadin extends SpringBootServletInitializer {

    private static BootStrap bootStrap;

    public static void main(String[] args) {
        startSpring(args);
    }

    public static void startSpring(String[] args) {
        Constants.get().setApplicationContext(SpringApplication.run(JavaSpringBootVaadin.class, args));
        bootStrap = new BootStrap();
        bootStrap.init();
    }

    public static void stop() {
        if (bootStrap != null) {
            bootStrap.destroy();
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JavaSpringBootVaadin.class);
    }
}
