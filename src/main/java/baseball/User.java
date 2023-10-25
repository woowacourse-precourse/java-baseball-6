package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int INPUT_LENGTH = 3;
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    int[] userBaseBallNumber = new int[INPUT_LENGTH];

    public void getUserInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        for (int i = 0; i < INPUT_LENGTH; i++) {
            this.userBaseBallNumber[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
    }
}
