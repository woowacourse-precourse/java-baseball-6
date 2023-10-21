package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> userNumber = new ArrayList<>();

    public User(String number){
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
        if (number.length() != 3) {
            throw new IllegalArgumentException("길이가 3이 아닙니다.");
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
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
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
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private void generateUser(String number) {
        for (String stringNumber : number.split("")) {
            int intNumber = Integer.parseInt(stringNumber);
            userNumber.add(intNumber);
        }
    }
}
