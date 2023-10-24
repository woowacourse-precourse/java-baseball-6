package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private final List<Integer> userInputList;
    private static final int ANSWER_LENGTH = 3;

    public User(String userInput) {
        userInputNotNumber(userInput);
        userInputLengthException(userInput);
        this.userInputList = stringToIntegerList(userInput);
        isUnique(userInputList);
    }

    public List<Integer> getUserInputList() {
        return userInputList;
    }

    private void userInputLengthException(String userInput) {
        if (userInput.length() != ANSWER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void userInputNotNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!userInput.matches("-?\\d+")) {
                throw new IllegalArgumentException();
            }
        }
    }


    private void isUnique(List<Integer> userInput) {
        Set<Integer> set = new HashSet<>(userInput);
        if (set.size() != ANSWER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> stringToIntegerList(String userInput) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            integerList.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
        }
        return integerList;
    }


}
