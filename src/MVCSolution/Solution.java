package MVCSolution;

import MVCSolution.controller.Controller;
import MVCSolution.model.FakeModel;
import MVCSolution.model.MainModel;
import MVCSolution.model.Model;
import MVCSolution.view.EditUserView;
import MVCSolution.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();

        editUserView.setController(controller);
        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Ivanov", 123, 5);
        usersView.fireEventShowDeletedUsers();
    }
}