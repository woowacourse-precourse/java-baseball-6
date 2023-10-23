package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String inputRegameMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String inputBalls() {
        System.out.print(inputMessage);
        return Console.readLine();
    }

    public static int inputRegame() {
        System.out.println(inputRegameMessage);
        String inputData = Console.readLine();//validate필요
        return Integer.parseInt(inputData);
    }

}

