package baseball.view;

import baseball.util.Convert;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public List<Integer> inputUserNumber() {
        String input = readLine();
        return Convert.convertStringToIntegerList(input);
    }

    public int inputRestartOrExitNumber() {
        String input = readLine();
        return Convert.convertStringToInteger(input);
    }
}
