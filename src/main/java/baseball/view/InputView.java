package baseball.view;

import baseball.util.Convert;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public List<Integer> inputUserNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String input = readLine();
        System.out.println();
        return Convert.convertStringToIntegerList(input);
    }

    public int inputRestartOrExitNumber() {
        String input = readLine();
        System.out.println();
        return Convert.convertStringToInteger(input);
    }

}
