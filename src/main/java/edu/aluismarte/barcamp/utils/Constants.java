package edu.aluismarte.barcamp.utils;

import edu.aluismarte.barcamp.JavaSpringBootVaadin;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

/**
 * Created by aluis on 9/30/19.
 */
public class Constants {

    private static volatile Constants instance = null;

    private ConfigurableApplicationContext applicationContext;

    private Constants() {
    }

    public static Constants get() {
        Constants result = instance;
        if (result == null) {
            synchronized (Constants.class) {
                if (instance == null) {
                    instance = result = new Constants();
                }
            }
        }
        return result;
    }

    public void setApplicationContext(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.applicationContext.addApplicationListener((ApplicationListener<ContextClosedEvent>) event -> JavaSpringBootVaadin.stop());
        autoWiredClass(this);
    }

    public void autoWiredClass(Object objectToWired) {
        applicationContext.getAutowireCapableBeanFactory().autowireBean(objectToWired);
    }
}
