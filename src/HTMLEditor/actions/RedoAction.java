package HTMLEditor.actions;

import HTMLEditor.View;

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
