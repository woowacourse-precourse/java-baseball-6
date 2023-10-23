package baseball;

import java.util.HashSet;
import java.util.Set;

public class UserNumber {

    private static final int MAX_NUMBER_LENGTH = 3;
    private final String number;


    public UserNumber(String number) {
        validateLength(number);
        validateNumber(number);
        validateDuplication(number);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void validateLength(String userNumber) {
        if (userNumber.length() != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumber(String userNumber) {
        if (!userNumber.matches("^[1-9]*$")) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplication(String number) {
        Set<Character> validateNumber = getCharacters(number);
        if (validateNumber.size() != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private Set<Character> getCharacters(String number) {
        Set<Character> validateNumber = new HashSet<>();

        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            validateNumber.add(number.charAt(i));
        }
        return validateNumber;
    }


}