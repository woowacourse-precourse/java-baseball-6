package baseball.view;

import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Numbers readUserNumbers() {
        String input = Console.readLine();

        return new Numbers(input);
    }
}
