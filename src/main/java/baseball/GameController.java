package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private static final String INPUT_PROMPT = "숫자를 입력해주세요: ";

    public void startGame() {
        String userInput = readUserInput(INPUT_PROMPT);
        System.out.println(userInput);
    }

    public static String readUserInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
