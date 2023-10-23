package baseball;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;


public class User {
    private static final int INPUT_LENGTH = 3;
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_ERROR_MESSAGE = "3자리 정수를 입력해주세요.";
    private static final String INPUT_REGEX = "^[1-9]{3}$";

    int[] userInput = new int[INPUT_LENGTH];

    public void setUserInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        checkInputType(input);
        checkDuplicateInput(input);

        for(int i = 0; i < INPUT_LENGTH; i++){
            userInput[i] = Character.getNumericValue(input.charAt(i));
        }
    }

    private void checkInputType(String input) {
        if(!input.matches(INPUT_REGEX)) {
            throw  new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private void checkDuplicateInput(String input) {
        Set<Character> uniqueInput = new HashSet<>();

        for(char c : input.toCharArray()) {
            hasDuplicateCharacter(uniqueInput, c);
        }
    }

    private void hasDuplicateCharacter(Set<Character> uniqueInput, char c) {
        if(!uniqueInput.add(c)) {
            throw  new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

}
