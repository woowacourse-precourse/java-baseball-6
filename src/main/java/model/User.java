package model;

public class User {
    private char[] selectUsers;

    public User(char[] selectUsers) {
        try {
            this.selectUsers = selectUsers;
        }
        catch (NullPointerException e) {
            throw new NullPointerException("Exception occur User Class: NullPointerException");
        }
    }

    public char[] getterSelectUsersNum() {
        return selectUsers.clone();
    }
}
