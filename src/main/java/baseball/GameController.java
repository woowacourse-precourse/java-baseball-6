package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameController {

    private static final String START_PROMPT = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_PROMPT = "숫자를 입력해주세요 :";

    private static final int startInclusive = 1;
    private static final int endInclusive = 9;
    private static final int count = 3;

    private Computer computer;

    public GameController() {
        computer = new Computer();
    }

    public void startGame() {

        List<Integer> randomNumbers = computer.generateRandomNumbers(startInclusive, endInclusive, count);
        System.out.println(START_PROMPT);
        String userInput = readUserInput(INPUT_PROMPT);
        System.out.println(userInput);
        System.out.println("randomNumbers = " + randomNumbers);
    }

    public static String readUserInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
