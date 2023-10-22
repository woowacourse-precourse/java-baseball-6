package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int askNumber() {
        System.out.println("숫자를 입력해주세요");
        return getInt();
    }

    public static int askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return getInt();
    }

    private static int getInt() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

}
