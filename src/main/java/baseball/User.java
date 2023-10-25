package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> userNumber = new ArrayList<>();

    public User(String number) {
        validateStringNumber(number);
        generateUser(number);
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    private void validateStringNumber(String number) {
        checkLength(number);
        checkInteger(number);
        checkDuplicateNumber(number);
    }

    private void checkLength(String number) {
        if (number.length() != Constant.NUMBER_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_LENGTH);
        }
    }

    private void checkDuplicateNumber(String number) {
        for (String stringNumber : number.split("")) {
            int intNumber = Integer.parseInt(stringNumber);
            checkForDuplicate(intNumber);
        }
    }

    private void checkForDuplicate(int intNumber) {
        if (userNumber.contains(intNumber)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER);
        }
    }

    private void checkInteger(String number) {
        for (String stringNumber : number.split("")) {
            validateNumber(stringNumber);
        }
    }

    private static void validateNumber(String stringNumber) {
        try {
            int intNumber = Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_NUMBER);
        }
    }

    private void generateUser(String number) {
        for (String stringNumber : number.split("")) {
            int intNumber = Integer.parseInt(stringNumber);
            userNumber.add(intNumber);
        }
    }
}