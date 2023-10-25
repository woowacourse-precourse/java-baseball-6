package controller;
import model.User;

public class SelectUserNum {
    private String selectUsers;

    private User user;
    public SelectUserNum(String selectUsers) {
        try{
            isValid(selectUsers);
            this.selectUsers = selectUsers;

            user = new User(selectUsers);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Exception occurs in SelectUserNum Class: IllegalArgumentException: close");
        }catch (NullPointerException e) {
            throw new IllegalArgumentException("Exception occurs in SelectUserNum Class: NullPointerException: close");
        }
    }

    private void isValid(String selectUsers) {
        validateSelectNum(selectUsers);
        checkDuplication(selectUsers);
    }

    private void validateSelectNum(String selectUsers) {
        if((selectUsers.length() != 3) || !(selectUsers.chars().allMatch(Character::isDigit))) {//is not int Array
            throw new IllegalArgumentException("close: Invalid argument: " + selectUsers);
        }
    }

    private boolean checkDuplication(String selectUsers) {
        for (int i = 0; i < selectUsers.length() - 1; i++) {
            if (selectUsers.charAt(i) == selectUsers.charAt(i + 1)) {
                throw new IllegalArgumentException("close: Invalid argument: Duplication");
            }
        }
        return false;
    }

    public User returnSelectUserNum() {
        try{
            return user;
        }
        catch (NullPointerException e) {
            throw new NullPointerException("Reference is null");
        }
    }
}