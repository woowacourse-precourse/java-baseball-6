package baseball.model;

import baseball.controller.CheckInput;
import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    public List<Integer> userNumber = new ArrayList<>();

    public UserNumber(String userInput) {
        CheckInput.checkNumberRules(userInput);
        this.userNumber = changeInputToInt(userInput);
    }

    public boolean contains(int number) {
        return this.userNumber.contains(number);
    }

    public int indexOf(int number) {
        return this.userNumber.indexOf(number);
    }

    public int get(int number) {
        return this.userNumber.get(number);
    }

    public static List<Integer> changeInputToInt(String userInput) {
        List<Integer> userInputInt = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            userInputInt.add(c - '0');
        }
        return userInputInt;
    }

}
