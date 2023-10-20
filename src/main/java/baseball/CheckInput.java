package baseball;

import java.util.Set;
import java.util.stream.Collectors;

public class CheckInput {
    public static void validateUserInput(String userInput) {
        validateLength(userInput);
        validateInteger(userInput);
        validateHasZero(userInput);
        validateDuplicate(userInput);        
    }
    
    private static void validateLength(String userInput) {
        if(userInput.length()!=3){
            throw new IllegalArgumentException();
        }
    }
    private static void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        }catch (IllegalArgumentException error){
            throw new IllegalArgumentException();
        }
    }
    private static void validateHasZero(String userInput) {
        if(userInput.contains("0")){
            throw new IllegalArgumentException();
        }
    }
    private static void validateDuplicate(String userInput) {
        Set<Character> characterSet = userInput.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());
        if (characterSet.size()!=3){
            throw new IllegalArgumentException();
        }
    }
}
