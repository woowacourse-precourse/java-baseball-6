package baseball.model;

import baseball.utils.UserInputNumberValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserInputNumber {

    private final List<Integer> userNumber = new ArrayList<>();

    public UserInputNumber(String userNumber) {
        UserInputNumberValidator.validate(userNumber);
        convertInputStringToList(userNumber);
    }


    private void convertInputStringToList(String userInputNumber) {
        for (char ch : userInputNumber.toCharArray()) {
            userNumber.add(Character.getNumericValue(ch));
        }
    }

    public List<Integer> userNumberToList() {
        return Collections.unmodifiableList(userNumber);
    }

}
