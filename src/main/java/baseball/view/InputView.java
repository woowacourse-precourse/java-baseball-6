package baseball.view;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String requestRestartGame() {
        String message = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", Constant.GAME_RESTART, Constant.GAME_STOP);
        System.out.println(message);
        return Console.readLine();
    }


}
