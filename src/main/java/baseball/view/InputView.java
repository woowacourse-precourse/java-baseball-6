package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        return Console.readLine();
    }

    public static String printRetryMessage() {
        System.out.println("게임을 다시 시작하려면 1. 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
