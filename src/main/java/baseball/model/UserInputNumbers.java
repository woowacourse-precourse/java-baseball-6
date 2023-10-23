package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserInputNumbers {

    private final List<Number> userNumberList;

    public UserInputNumbers(String userInput) {
        this.userNumberList = userInputToNumbers(userInput);
    }

    private List<Number> userInputToNumbers(String userInput) {
        List<Number> numberList = new ArrayList<>();
        for (char numberCharacter : userInput.toCharArray()) {
            Number inputNumber = new Number(Character.getNumericValue(numberCharacter));
            numberList.add(inputNumber);
        }
        return numberList;
    }


    public List<Number> getUserNumberList() {
        return userNumberList;
    }
}
