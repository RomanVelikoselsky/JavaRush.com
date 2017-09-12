package HTMLEditor.actions;

import HTMLEditor.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by v.roman on 04.08.2017.
 */
public class UndoAction extends AbstractAction {
    private View view;

    public UndoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        view.undo();
    }
}
