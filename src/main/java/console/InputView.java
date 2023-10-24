package console;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputView {

    private static final String INVALID_INPUT = "유효하지 않은 입력입니다.";
    private static final String RETRY_OPTION = "1";
    private static final int VALID_INPUT_LENGTH = 3;
    public String getUserInput(){
        String userInput = Console.readLine();
        validateInput(userInput);
        return userInput;
    }

    public boolean isContinuable(){
        String userInput = Console.readLine();
        return userInput.equals(RETRY_OPTION);
    }

    private void validateInput(String userInput) {
        if (userInput.length() != VALID_INPUT_LENGTH) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        try{
            Integer.parseInt(userInput);
        } catch (Exception e){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        if (isDuplicatedNumber(userInput)){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private boolean isDuplicatedNumber(String userInput) {
        Set<Character> uniqueChars = new HashSet<>();
        char[] userInputCharArray = userInput.toCharArray();
        for (char c : userInputCharArray) {
            uniqueChars.add(c);
        }
        return uniqueChars.size() != VALID_INPUT_LENGTH;
    }
}