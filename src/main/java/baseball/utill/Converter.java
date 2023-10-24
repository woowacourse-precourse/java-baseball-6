package baseball.utill;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public List<Integer> convertToNumericList(List<String> stringList) {
        return stringList.stream()
                .map(this::parseInt)
                .collect(Collectors.toList());
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BALL_COUNT.getMessage());
        }
    }
}
