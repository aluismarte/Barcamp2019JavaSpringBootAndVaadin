package edu.aluismarte.barcamp.solution;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UncheckedIOException;

/**
 * Created by aluis on 11/20/19.
 */
@Route("simple")
@JsModule("@google/model-viewer")
@NpmPackage(value = "@google/model-viewer", version = "0.7.2")
public class Simple extends VerticalLayout {

    public Simple() {
        File model = new File("./models/Horse.glb");
        Element modelViewer = new Element("model-viewer");
        modelViewer.setAttribute("camera-controls", true);
        modelViewer.setAttribute("src", new StreamResource(model.getName(), (InputStreamFactory) () -> {
            try {
                return new FileInputStream(model);
            } catch (FileNotFoundException ex) {
                throw new UncheckedIOException(ex);
            }
        }));
        getElement().appendChild(modelViewer);
        setSizeFull();
    }
}
