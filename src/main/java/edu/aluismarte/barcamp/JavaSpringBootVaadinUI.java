package edu.aluismarte.barcamp;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Created by aluis on 9/30/19.
 */
@Route("")
public class JavaSpringBootVaadinUI extends VerticalLayout {

    public JavaSpringBootVaadinUI() {
        add(new Text("Hola Vaadin"));
    }
}
