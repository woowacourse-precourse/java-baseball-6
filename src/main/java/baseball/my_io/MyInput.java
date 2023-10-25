package baseball.my_io;

import baseball.my_func.NumCheck;
import camp.nextstep.edu.missionutils.Console;

public class MyInput {
    /*
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE_ENTER_USER_INPUT = "숫자를 입력해주세요 : ";
    private static final String INPUT_MESSAGE_CONTINUE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    */
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String receiveUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static boolean decideContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameCode = Console.readLine();
        NumCheck.choiceGameMenu(gameCode);
        return gameCode.equals("1");
    }
}
