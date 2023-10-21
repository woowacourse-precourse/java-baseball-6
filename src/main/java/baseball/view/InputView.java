package baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String DIGIT_EXCEPTION_MESSAGE = "3자리 수를 입력하세요.";
    private static final String RANGE_EXCEPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String THREE_DIGIT_NUMBER_REGEX = "^\\d{3}$";
    private static final String ONE_OR_TWO_REGEX = "^[1-2]*$";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    public String printInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String input = deleteBlank(readLine());
        validateNumericAndThreeDigit(input);
        return input;
    }

    public static void validateNumericAndThreeDigit(String input) {
        Matcher matcher = Pattern.compile(THREE_DIGIT_NUMBER_REGEX).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(DIGIT_EXCEPTION_MESSAGE);
        }
    }

    public String printRestartNumber() {
        System.out.println(INPUT_RESTART_MESSAGE);
        String input = deleteBlank(readLine());
        validateOneOrTwo(input);
        return input;
    }

    public static void validateOneOrTwo(String input) {
        Matcher matcher = Pattern.compile(ONE_OR_TWO_REGEX).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }

    public String deleteBlank(String input) {
        return input.replace(BLANK, EMPTY);
    }

}
