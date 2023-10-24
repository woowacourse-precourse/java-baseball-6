package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String inputBalls() {
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String inputRegame() {
        System.out.println(INPUT_REGAME_MESSAGE);
        return Console.readLine();
    }

}

