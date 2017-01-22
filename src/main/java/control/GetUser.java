package control;

import dto.User;

public class GetUser {

    public User execute(String userID) {
        return getTestUser();
    }

    private User getTestUser() {
        User user = new User();
        user.setUserID("1");
        user.setName("Taylor Swift");
        return user;
    }
}
