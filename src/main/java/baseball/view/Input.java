package baseball.view;

import baseball.service.Exception;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final Exception exception = new Exception();

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        exception.validateInputNumber(number);
        return number;
    }
}
