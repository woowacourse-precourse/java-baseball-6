package baseball.View;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String inputNumberMsg = "숫자를 입력해주세요 : ";
    private static final String afterGameMsg = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public String enterAskNumber() {
        System.out.println(inputNumberMsg);
        return Console.readLine();
    }

    public String enterAskRestart() {
        System.out.println(afterGameMsg);
        return Console.readLine();
    }
}
