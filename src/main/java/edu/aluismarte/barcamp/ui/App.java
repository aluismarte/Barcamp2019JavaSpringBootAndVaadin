package edu.aluismarte.barcamp.ui;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * Base de la app para mostrar la data.
 *
 * Created by aluis on 9/30/19.
 */
public class App extends VerticalLayout {

    public App() {
        add(new Label("Hello app!"));
    }
}
