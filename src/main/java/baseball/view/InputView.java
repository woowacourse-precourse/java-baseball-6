package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String askNumber() {
        System.out.println("숫자를 입력해주세요");
        return getString();
    }

    public static String askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return getString();
    }


    private static String getString() {
        String str = Console.readLine();
        if (str.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요");
        }
        return str;
    }

}
