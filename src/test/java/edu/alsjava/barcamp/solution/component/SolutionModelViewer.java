package edu.alsjava.barcamp.solution.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;

import java.io.*;

/**
 * Created by aluis on 11/20/19.
 */
@Tag("model-viewer")
@JsModule("@google/model-viewer")
@NpmPackage(value = "@google/model-viewer", version = "0.7.2")
public class SolutionModelViewer extends Component implements HasSize {

    public SolutionModelViewer() {
        getElement().setAttribute("camera-controls", true);
    }

    public void setSrc(File file) {
        if (file == null) {
            getElement().removeAttribute("src");
            return;
        }
        getElement().setAttribute("src", new StreamResource(file.getName(), (InputStreamFactory) () -> {
            try {
                return new FileInputStream(file);
            } catch (FileNotFoundException ex) {
                throw new UncheckedIOException(ex);
            }
        }));
    }
}
