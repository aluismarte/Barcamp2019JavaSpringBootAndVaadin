package edu.aluismarte.barcamp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * Created by aluis on 9/30/19.
 */
@Route("")
public class JavaSpringBootVaadinUI extends VerticalLayout {

    public JavaSpringBootVaadinUI() {
        setSizeFull();
        TextField tfName = new TextField("Name?");
        Button btnHi = new Button("Hi!");
        btnHi.addClickListener(event -> Notification.show("Hi! " + tfName.getValue()));
        VerticalLayout vlMainlayout = new VerticalLayout(tfName, btnHi);
        vlMainlayout.setSizeFull();
        add(vlMainlayout);
    }
}
