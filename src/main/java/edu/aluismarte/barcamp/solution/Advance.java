package edu.aluismarte.barcamp.solution;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import java.io.File;

/**
 * Created by aluis on 11/20/19.
 */
@Push // Hacer que la UI responda por eventos al server
@Route("advance")
@BodySize(height = "100vh", width = "100vw") // Responsive
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes") // Responsive
@PWA(name = "View Model Componente like native vaadin componente", shortName = "View Model Vaadin") // Permite hacer el concepto de Progress Web Application
public class Advance extends VerticalLayout {

    public Advance() {
        File dir = new File("./models");
        File[] files = dir.listFiles(file -> file.getName().endsWith(".glb"));
        if (files == null || files.length == 0) {
            return;
        }
        SolutionModelViewer modelViewer = new SolutionModelViewer();
        modelViewer.setSizeFull();
        modelViewer.setSrc(files[0]);
        modelViewer.setSizeFull();

        Grid<File> grid = new Grid<>();
        grid.setSizeFull();
        grid.setItems(files);
        grid.addColumn(File::getName).setHeader("File");

        grid.addSelectionListener(event -> modelViewer.setSrc(event.getFirstSelectedItem().orElse(null)));

        SplitLayout splitLayout = new SplitLayout(modelViewer, grid);
        splitLayout.setSizeFull();
        add(splitLayout);
        setSizeFull();
    }
}
