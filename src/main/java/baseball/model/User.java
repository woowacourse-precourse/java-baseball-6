package baseball.model;

import java.util.Arrays;
import java.util.HashSet;

public class User {

    private String userNumber;

    public String getUserNumber(){
        return userNumber;
    }
    public void setUserNumber(String userInput) {
        this.userNumber = userInput;
    }

    public void validateUserInput(String userInput) throws IllegalArgumentException {
        String regex = "[1-9]+";
        boolean isInvalidDigit = !userInput.matches(regex);

        if (isInvalidDigit || userInput.length() > 3 || isDuplicationDigit(userInput)) {
            throw new IllegalArgumentException();
        }



    }

    public boolean isDuplicationDigit(String userInput) {
        HashSet<Character> userInputDigit = new HashSet<>();

        for (char c : userInput.toCharArray()) {
            if (userInputDigit.contains(c)){
                return true;
            }
            userInputDigit.add(c);
        }

        return false;

    }
}
