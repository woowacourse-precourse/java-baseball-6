package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String NUMBER_RANGE = "^[1-9]*$";
    private static final String NUMBER_SEPARATE_DELIMITER = "";
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
}
