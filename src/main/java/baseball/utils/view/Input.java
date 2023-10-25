package baseball.utils.view;

import baseball.number.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public Numbers inputNumbers() {
        return new Numbers(Console.readLine());
    }

    public String inputRestart() {
        return Console.readLine();
    }
}
