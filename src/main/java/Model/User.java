package Model;

import Util.Validator;

public class User {

    private String userNumber;

    public User() {
    }

    public String getuserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        Validator.validateUserInput(userNumber);
        this.userNumber = userNumber;
    }
}
