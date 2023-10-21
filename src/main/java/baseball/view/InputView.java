package baseball.view;

import baseball.util.Validation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Validation.isValidInput(Console.readLine());
    }
}