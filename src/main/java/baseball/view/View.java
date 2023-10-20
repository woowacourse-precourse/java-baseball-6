package baseball.view;

import camp.nextstep.edu.missionutils.Console;
public class View {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static String printInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        return input;
    }
}
