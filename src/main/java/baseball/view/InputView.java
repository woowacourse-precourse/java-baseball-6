package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUIRE_BASEBALL_NUMBER = "숫자를 입력해주세요";
    private static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String requireBASEBALLNUMBER(){
        System.out.println(REQUIRE_BASEBALL_NUMBER);
        return Console.readLine();
    }
    public static String askContinue(){
        System.out.println(CONTINUE_MESSAGE);
        return Console.readLine();
    }

}
