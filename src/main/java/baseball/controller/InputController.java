package baseball.controller;


import camp.nextstep.edu.missionutils.Console;

public class InputController {

    public String playerInput() {
        String inputString = Console.readLine();
        validate(inputString);
        return inputString;
    }
    private void validate(String input) {
        checkIsNum(input);
        checkLength(input);
        checkAllDiffer(input);
    }
    private void checkIsNum(String input){
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkAllDiffer(String input) {
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }
}
