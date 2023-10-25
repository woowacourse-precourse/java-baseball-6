package baseball.domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {
    private final List<Integer> userNumber;

    private static final int NUMBER_SIZE = 3;

    public UserNumber(String userNumber) {
        validate(userNumber);
        this.userNumber =  Arrays.stream(userNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    private void validate(String userNumber) {
        validateNumberLength(userNumber);
        validateInteger(userNumber);
        validateNotContainZero(userNumber);
        validateNotDuplication(userNumber);
    }

    private void validateNumberLength(String userNumber) {
        if(userNumber.length() != NUMBER_SIZE)
            throw new IllegalArgumentException();
    }

    private void validateInteger(String userNumber) {
        try {
            Integer.parseInt(userNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotContainZero(String userNumber) {
        if(userNumber.contains("0"))
            throw new IllegalArgumentException();
    }


    private void validateNotDuplication(String userNumber) {
        int setSize = Arrays.asList(userNumber.split("")).stream()
                .distinct()
                .collect(Collectors.joining()).length();
        if(!(setSize == NUMBER_SIZE))
            throw new IllegalArgumentException();
    }


}
