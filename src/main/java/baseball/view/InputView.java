package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputNumbers() {
        String numbers = Console.readLine();
        return numbers;
    }

    public String inputGameSelect() {
        return Console.readLine();
    }
}
