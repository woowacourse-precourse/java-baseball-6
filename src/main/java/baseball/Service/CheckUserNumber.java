package baseball.Service;

import java.util.HashSet;
import java.util.Set;

public class CheckUserNumber {

    public CheckUserNumber(String String){
        CheckLength(String);
        CheckInt(String);
        CheckDuplicate(String);
    }

    private void CheckLength(String String){
        if(String.length() != 3)
            throw new IllegalArgumentException();

    }

    private void CheckInt(String String){
        try {
            int inputInt = Integer.parseInt(String);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void CheckDuplicate(String String){
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < String.length(); i++) {
            char currentChar = String.charAt(i);
            if (charSet.contains(currentChar)) {
                throw new IllegalArgumentException();
            }
            charSet.add(currentChar);
        }
    }
}
