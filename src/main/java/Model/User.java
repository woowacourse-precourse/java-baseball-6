package Model;

import Util.Validator;
import camp.nextstep.edu.missionutils.Console;

public class User {

    private String userNumber;

    public User() {
    }

    public String getuserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        try {
            Validator.validateUserInput(userNumber);
            Validator.validateInputLength(userNumber, 3);
            this.userNumber = userNumber;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
