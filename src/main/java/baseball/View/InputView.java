package baseball.View;

import baseball.Model.NumberModel;
import baseball.util.Verify;

import static baseball.util.InputNumber.getInputNumber;
import static baseball.util.InputNumber.getRestartNumber;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static NumberModel getUserInput() throws IllegalArgumentException {
        System.out.println("숫자를 입력해주세요 : ");
        String input = readLine();
        return getInputNumber(input);
    }

    public static String getRestartValue() throws IllegalArgumentException {
        String restart = readLine();
        return getRestartNumber(restart);
    }
}
