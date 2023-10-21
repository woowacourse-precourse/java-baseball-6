package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private final String RETRY_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public int print_input_message() {
        System.out.print(INPUT_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    public int print_retry_message() {
        System.out.println(RETRY_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
