package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    // 유저가 숫자를 입력합니다.
    public static String enterUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    // 게임을 새로 시작하거나, 종료하려면 1 또는 2 입력
    public static String choiceRetryGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
