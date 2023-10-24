package baseball.model;

import baseball.Message;
import baseball.NumberLimits;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    private final List<Integer> userNumberList;

    public User(String inputUserNumber) {
        this.userNumberList = Arrays.stream(inputUserNumber.split(""))
                .map(this::getNumber)
                .collect(Collectors.toList());
        validateInput();
    }

    private int getNumber(String userNumber) {
        try {
            return Integer.parseInt(userNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INVALID_VALUE.getMessage());
        }
    }

    private void validateInput() {
        checkListLength();
        checkNumberRange();
        checkForDuplicates();
    }

    private void checkListLength() {
        if (userNumberList.size() != NumberLimits.NUM_LIST_LENGTH.getValue()) {
            throw new IllegalArgumentException(Message.THREE_NUMBERS_REQUIRED.getMessage());
        }
    }

    private void checkNumberRange() {
        for (Integer num : userNumberList) {
            if (num < NumberLimits.MIN_VALUE.getValue() || num > NumberLimits.MAX_VALUE.getValue()) {
                throw new IllegalArgumentException(Message.NUMBER_RANGE.getMessage());
            }
        }
    }

    private void checkForDuplicates() {
        Set<Integer> set = new HashSet<>(userNumberList);
        if (set.size() < NumberLimits.NUM_LIST_LENGTH.getValue()) {
            throw new IllegalArgumentException(Message.UNIQUE_NUMBERS.getMessage());
        }
    }

    public List<Integer> getUserNumberList() {
        return userNumberList;
    }

}
