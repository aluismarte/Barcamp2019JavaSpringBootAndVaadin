package edu.aluismarte.barcamp.solution;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.Route;

import java.io.File;

/**
 * Created by aluis on 11/20/19.
 */
@Route("advance")
public class GridAdd extends VerticalLayout {

    public GridAdd() {
        File dir = new File("./models");
        File[] files = dir.listFiles(file -> file.getName().endsWith(".glb"));
        if (files == null || files.length == 0) {
            return;
        }
        VaadinModelViewer modelViewer = new VaadinModelViewer();
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
    }
}
