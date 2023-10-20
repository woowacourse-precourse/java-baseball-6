package baseball.controller;


import camp.nextstep.edu.missionutils.Console;

public class InputController {

    public String playerInput() {
        String inputString = Console.readLine();
        validate(inputString);
        return inputString;
    }


    private void validate(String input) {
        try {
            int a = Integer.parseInt(input);
            System.out.println(a);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
