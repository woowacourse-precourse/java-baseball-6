package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public String enterGameNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNumber = Console.readLine();
        return inputNumber;
    }
}
