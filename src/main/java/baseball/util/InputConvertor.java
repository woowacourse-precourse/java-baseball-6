package baseball.util;

import baseball.domain.Retry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConvertor {

    private static final String BLANK = "";

    public static List<Integer> convertBalls(String rawBalls) {
        String[] rawBallStrings = rawBalls.split(BLANK);
        return Arrays.stream(rawBallStrings)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
