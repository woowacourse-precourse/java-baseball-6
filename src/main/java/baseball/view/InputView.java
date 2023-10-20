package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readBaseballNumber() {
        System.out.printf("숫자를 입력해주세요 : ");
        String inputValue = Console.readLine();
        return inputValue;
    }

    public static String readRestart() {
        System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputValue = Console.readLine();
        return inputValue;
    }
}
