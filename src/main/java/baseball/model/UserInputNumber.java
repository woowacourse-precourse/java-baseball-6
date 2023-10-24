package baseball.model;

import baseball.utils.UserInputNumberValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputNumber {

    private static final int NUMBER_SIZE = 3;
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
