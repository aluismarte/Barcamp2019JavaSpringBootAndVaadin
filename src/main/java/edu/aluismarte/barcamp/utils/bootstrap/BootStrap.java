package edu.aluismarte.barcamp.utils.bootstrap;

import edu.aluismarte.barcamp.utils.Constants;

/**
 * Created by aluis on 9/30/19.
 */
public class BootStrap {

    public BootStrap() {
        Constants.get().autoWiredClass(this);
    }

    public void init() {
    }

    public void destroy() {
    }
}
