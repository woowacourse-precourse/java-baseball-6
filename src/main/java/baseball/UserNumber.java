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

    public void validateLength(String number) {
        if (number.length() != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumber(String number) {
        if (!number.matches("^[1-9]*$")) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplication(String number) {
        Set<Character> validateNumber = extractCharactersToSet(number);
        if (validateNumber.size() != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private Set<Character> extractCharactersToSet(String number) {
        Set<Character> validatedNumber = new HashSet<>();
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            validatedNumber.add(number.charAt(i));
        }
        return validatedNumber;
    }


}