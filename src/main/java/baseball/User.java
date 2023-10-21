package baseball;

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
        checkInputLength(input);
        checkDuplicateInput(input);
        for (int i = 0; i < INPUT_LENGTH; i++){
            this.userInput[i] = input.charAt(i);
        }

    }

}
