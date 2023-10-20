package baseball.converter;

import baseball.domain.number.Numbers;
import baseball.enums.OverallGameStatus;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BaseBallConverter {

    private BaseBallConverter() {
    }

    public static Numbers stringToNumbers(String numberString) {
        validateIsNumber(numberString);

        return Numbers.create(Arrays.stream(numberString.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
    }

    private static void validateIsNumber(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
    }

    public static OverallGameStatus stringToOverallGameStatus(String continueString) {
        return OverallGameStatus.valueOfInputString(continueString);
    }


}
