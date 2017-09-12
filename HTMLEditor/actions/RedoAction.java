<<<<<<< HEAD
package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by v.roman on 07.08.2017.
 */
public class RedoAction extends AbstractAction {
    private View view;

    public RedoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        view.redo();
    }
}
=======
package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by v.roman on 07.08.2017.
 */
public class RedoAction extends AbstractAction {
    private View view;

    public RedoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        view.redo();
    }
}
>>>>>>> 150b183e56bce5788ac88e08113791e83b497b73
