package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.validation.Validation.valiInputNumber;
import static baseball.validation.Validation.valiRestartInput;

public class Input {
    private static final String GAME_START_MESSAGE =  "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String USER_ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static void gameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static String inputNumber() {
        System.out.print(USER_INPUT_NUMBER_MESSAGE);
        String userInput = Console.readLine();
        valiInputNumber(userInput);
        return userInput;
    }

    public static String inpuRestartNumber() {
        System.out.println(USER_ASK_RESTART_MESSAGE);
        String restartInput = Console.readLine();
        valiRestartInput(restartInput);
        return restartInput;
    }
}
