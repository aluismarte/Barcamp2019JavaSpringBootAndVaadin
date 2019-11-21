package edu.aluismarte.barcamp;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.Route;

/**
 * Created by aluis on 9/30/19.
 */
@Push
@Route("")
@BodySize(height = "100vh", width = "100vw")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class JavaSpringBootVaadinUI extends VerticalLayout {

    public JavaSpringBootVaadinUI() {
        add(new Text("Hola Vaadin"));
    }
}
