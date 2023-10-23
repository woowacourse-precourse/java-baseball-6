package controller;
import model.User;

public class SelectUserNum {
    private static final int MAX_RANGE_OF_NUM = 57;//ASCII 9
    private static final int MIN_RANGE_OF_NUM = 49;//ASCII 1
    private char[] selectUsers;

    private User user;
    public SelectUserNum(char[] selectUsers) {
        isValid(selectUsers);
        this.selectUsers = selectUsers;

        user = new User(selectUsers);
    }

    private void isValid(char[] selectUsers) {
        validateSelectNum(selectUsers);
        checkDuplication(selectUsers);
    }

    private void validateSelectNum(char[] selectUsers) {
        for (int i = 0; i < 3; i++) {
            if((selectUsers.length > 3) || !((MIN_RANGE_OF_NUM <= selectUsers[i]) && (selectUsers[i] <= MAX_RANGE_OF_NUM))) {//is not int Array
                throw new IllegalArgumentException("Invalid argument: " + selectUsers[i]);
            }
        }
    }

    private boolean checkDuplication(char[] selectUsers) {
        for (int i = 0; i < selectUsers.length; i++) {
            for (int j = i + 1; j < selectUsers.length; j++) {
                if (selectUsers[i] == selectUsers[j]) {
                    throw new IllegalArgumentException("Invalid argument: Duplication");
                }
            }
        }
        return false;
    }

    public User returnSelectUserNum() {
        return user;
    }
}