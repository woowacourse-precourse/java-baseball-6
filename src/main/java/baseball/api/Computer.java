package baseball.api;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.api.constants.ResponseFormatConstants.*;
import static baseball.api.constants.ResponseFormatConstants.EMPTY_FORMAT;

public class Computer {
    private static final int NUMBER_LENGTH = 3;

    public static String getResult() {
        Set<String> computer = init();
        return computer.stream().collect(Collectors.joining());
    }

    private static Set<String> init() {
        Set<String> computer = new HashSet<>();
        while (computer.size() < NUMBER_LENGTH) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            computer.add(randomNumber);
        }
        return computer;
    }

    public static void hintMessage(int strikeCount, int ballCount) {
        String message = "";

        if (strikeCount > 0 && ballCount > 0) {
            message = String.format(BALL_AND_STRIKE_FORMAT, ballCount, strikeCount);
        } else if (strikeCount > 0) {
            message = String.format(STRIKE_FORMAT, strikeCount);
        } else if (ballCount > 0) {
            message = String.format(BALL_FORMAT, ballCount);
        } else {
            message = EMPTY_FORMAT;
        }

        System.out.println(message);
    }
}
