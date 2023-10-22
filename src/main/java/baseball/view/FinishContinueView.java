package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class FinishContinueView {
    public static final String MESSAGE_WIN_THE_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MESSAGE_DO_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NEW_GAME = "1";

    public static boolean finishOrContinueGame() {
        System.out.println(MESSAGE_WIN_THE_GAME);
        System.out.println(MESSAGE_DO_CONTINUE);
        String userInput = Console.readLine();

        if (userInput.equals(NEW_GAME)) {
            return true;
        }
        return false;
    }
}
