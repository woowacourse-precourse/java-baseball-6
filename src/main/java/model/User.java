package model;

public class User {
    private char[] selectUsers;

    public User(char[] selectUsers) {
        this.selectUsers = selectUsers;
    }

    public char[] getterSelectUsersNum() {
        return selectUsers.clone();
    }
}
