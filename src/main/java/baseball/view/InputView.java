package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String NUMBER_RANGE = "^[1-9]*$";
    private static final String NUMBER_SEPARATE_DELIMITER = "";
    private static final String YES = "1";
    private static final String NO = "2";
    private static final String RETRY_OR_END_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public static List<Integer> getNumbers() {
        System.out.print(GET_NUMBER_MESSAGE);
        String numbers = Console.readLine();
        validate(numbers);
        return mapToNumbers(numbers);
    }

    private static void validate(String numbers) {
        if (!numbers.matches(NUMBER_RANGE)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> mapToNumbers(String numbers) {
        return Arrays.stream(separate(numbers))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static String[] separate(String input) {
        return input.split(NUMBER_SEPARATE_DELIMITER);
    }

    public static boolean retryOrExit() {
        System.out.println(RETRY_OR_END_GAME_MESSAGE);
        String input = Console.readLine();
        validateUserChoice(input);
        return input.equals(YES);
    }

    public static void validateUserChoice(String input) {
        if (!input.equals(YES) && !input.equals(NO)) {
            throw new IllegalArgumentException();
        }
    }
}