package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.view.BaseballConsoleConstants.*;

public class InputView {
    public List<Integer> readThreeInputNumbers() {
        BaseballConsole.print(INPUT_NUMBER);
        String[] strings = Console.readLine().split(",");

        List<Integer> numbers = new ArrayList<>();
        for (String string : strings) {
            numbers.add(Integer.parseInt(string.trim()));
        }
        return numbers;
    }

    public boolean readContinueGame() {
        int input = Integer.parseInt(Console.readLine());
        if (input == 1) return true;
        return false;
    }
}

