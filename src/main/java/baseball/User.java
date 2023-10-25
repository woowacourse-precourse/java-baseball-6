package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    int[] userAnswer;
    public Integer strike;
    public Integer ball;

    public void makeUserNum() {
        String verifiedInput = getInput();
        userAnswer = convertUserNum(verifiedInput);
    }

    private String getInput() {
        String input = Console.readLine();
        InputVerification.verifyUserInput(input);
        return input;
    }

    private int[] convertUserNum(String numbersString) {
        String[] charArray = numbersString.split("");
        int[] numberArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            numberArray[i] = Integer.parseInt(charArray[i]);
        }
        return numberArray;
    }
}
