package boundary;

import control.GetUser;
import control.SaveUser;
import dto.User;

import javax.inject.Inject;

public class Users {

    @Inject
    GetUser getUser;

    @Inject
    SaveUser saveUser;

    public User findUser(String userID) {
        return getUser.execute(userID);
    }

    public void saveUser(User user) {
        saveUser.execute(user);
    }
}
