package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String NOT_NUMBER_MESSAGE = "숫자를 입력해주세요";
    private static final String INPUT_BASEBALL_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public List<Integer> readPlayerNumbers() {
        System.out.print(INPUT_BASEBALL_NUMBER_MESSAGE);
        return Arrays.stream(readInputString().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String readInputString() {
        String inputString = readLine();
        if (isNotNumber(inputString)) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
        return inputString;
    }

    private boolean isNotNumber(String inputString) {
        return !inputString.matches("\\d+");
    }

    public String readPlayerChoice() {
        System.out.println(INPUT_RETRY_MESSAGE);
        return readInputString();
    }
}
