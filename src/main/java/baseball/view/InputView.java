package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void getUserGuessingNumbers() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        String inputNumber = Console.readLine();
        System.out.println(inputNumber.getClass());
        System.out.println("inputNumber = " + inputNumber);
    }
}
