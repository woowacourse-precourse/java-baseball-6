package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private static final String START_PROMPT = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_PROMPT = "숫자를 입력해주세요 :";

    public void startGame() {
        System.out.println(START_PROMPT);
        String userInput = readUserInput(INPUT_PROMPT);
        System.out.println(userInput);
    }

    public static String readUserInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
