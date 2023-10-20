package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_NUMBERS = "숫자를 입력해주세요 :";

    public String inputNumbers() {
        System.out.println(INPUT_NUMBERS);
        return Console.readLine();
    }
}
