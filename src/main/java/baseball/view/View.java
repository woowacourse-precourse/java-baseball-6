package baseball.view;

import camp.nextstep.edu.missionutils.Console;
public class View {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static String printInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    public static void printRestart() {
        System.out.println(END_MESSAGE);
        System.out.println(RESTART_MESSAGE);
    }

}
