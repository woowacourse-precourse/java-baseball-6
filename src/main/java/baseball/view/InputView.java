package baseball.view;

import baseball.constant.Validation;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static List<Integer> getInputs() {
        String raw = Console.readLine();

        List<Integer> digits = new ArrayList<>();
        for (char ch : raw.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException();
            }
            digits.add(Character.getNumericValue(ch));
        }
        return digits;
    }

    public static String getIsGameContinue() {
        String raw = Console.readLine();

        if (!raw.equals(Validation.CONTINUE_GAME)
                & !raw.equals(Validation.FINISH_GAME)) {
            throw new IllegalArgumentException();
        }

        return raw;
    }
}
