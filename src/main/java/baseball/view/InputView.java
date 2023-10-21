package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static String REQUIRE_BASEBALL_NUMBER = "숫자를 입력하세요: ";
    private static final String RESTART_OR_EXIT="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";


    public static String userInputNumber(){
        System.out.print(REQUIRE_BASEBALL_NUMBER);
        String input = Console.readLine();
        return input;
    }
    public static String Retry(){
        System.out.println(RESTART_OR_EXIT);
        return Console.readLine();
    }
}
