package control;

import dto.User;

public class SaveUser {

    public void execute(User user) {
        System.out.println(user.getUserID());
        System.out.println(user.getName());
    }
}
