package MVCSolution.view;

import MVCSolution.controller.Controller;
import MVCSolution.model.ModelData;

/**
 * Created by v.roman on 29.06.2017.
 */
public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}
