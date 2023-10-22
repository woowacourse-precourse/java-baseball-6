package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        validateInputNumber(number);
        return number;
    }

    private void validateInputNumber(String input) {

    }
}
