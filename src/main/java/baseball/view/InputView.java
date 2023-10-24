package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public void readGameNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNumber = Console.readLine();
        System.out.println("inputNumber : " + inputNumber);
    }
}
