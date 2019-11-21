package edu.aluismarte.barcamp.solution;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * Created by aluis on 11/20/19.
 */
@Tag("model-viewer")
@JsModule("@google/model-viewer")
@NpmPackage(value = "@google/model-viewer", version = "0.7.2")
public class ModelViewer extends Component implements HasSize {

    public ModelViewer() {
    }
}
