package baseball.model;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {
    private List<Integer> userNumber;

    public UserNumber(String userNumber) {
        isValid(userNumber);
        this.userNumber =  Arrays.stream(userNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    private void isValid(String userNumber) {
        isCorrectSize(userNumber);
        isInteger(userNumber);
        isContainZero(userNumber);
        isDuplicate(userNumber);
    }

    private void isCorrectSize(String userNumber) {
        if(userNumber.length()!=3)
            throw new IllegalArgumentException();
    }

    private void isInteger(String userNumber) {
        try {
            Integer.parseInt(userNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void isContainZero(String userNumber) {
        if(userNumber.contains("0"))
            throw new IllegalArgumentException();
    }


    private void isDuplicate(String userNumber) {
        int setSize = Arrays.asList(userNumber.split("")).stream()
                .distinct()
                .collect(Collectors.joining()).length();
        if(!(setSize==3))
            throw new IllegalArgumentException();
    }


}
