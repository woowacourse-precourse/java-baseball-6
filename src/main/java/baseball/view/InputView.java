package baseball.view;

import baseball.constant.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

    private static final String SEPARATOR = "";

    public List<Integer> inputNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        validateNumeric(numbers);
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::valueOf)
                .collect(Collectors.toUnmodifiableList());
    }

    public Integer inputRestartOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String decisionNumber = Console.readLine();
        validateNumeric(decisionNumber);
        validateSingleLetter(decisionNumber);
        return Integer.valueOf(decisionNumber);
    }


    private void validateNumeric(String input) {
        if (input.isBlank() || !NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NUMERIC);
        }
    }

    private void validateSingleLetter(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(ExceptionMessage.SINGLE_LETTER);
        }
    }


}
