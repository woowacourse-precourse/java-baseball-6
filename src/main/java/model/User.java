package model;

public class User {
    private String selectUsers;

    public User(String selectUsers) {
        try {
            this.selectUsers = selectUsers;
        }
        catch (NullPointerException e) {
            throw new NullPointerException("Exception occur User Class: NullPointerException");
        }
    }

    public String getterSelectUsersNum() {
        String cloneSelectUser = selectUsers;
        return cloneSelectUser;
    }
}
