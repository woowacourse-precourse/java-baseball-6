package baseball.view;

import baseball.domain.GameControlCommand;
import baseball.domain.PlayerNumbers;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.Console;

public class View {

    private static final String MESSAGE_INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_INPUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String MESSAGE_OUTPUT_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static PlayerNumbers inputPlayerNumbers() {
        System.out.print(MESSAGE_INPUT_NUMBERS);
        String numbers = Console.readLine();
        return new PlayerNumbers(numbers);
    }

    public static GameControlCommand inputRestart() {
        System.out.println(MESSAGE_INPUT_RESTART);
        String number = Console.readLine();
        return GameControlCommand.of(number);
    }

    public static void printResult(Result result) {
        System.out.println(result);
    }

    public static void printGameEndMessage() {
        System.out.println(MESSAGE_OUTPUT_GAME_END);
    }
}
