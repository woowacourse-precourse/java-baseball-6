package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<String> inputNumbers() {
        return List.of(Console.readLine().split(""));
    }

    public static String inputNumber() {
        return Console.readLine();
    }
}
