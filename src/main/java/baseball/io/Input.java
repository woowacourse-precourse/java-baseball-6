package baseball.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String CONTINUE_GAME_SIG = "1";
    private static final String END_GAME_SIG = "2";

    public static boolean inputRestartGame() {
        String continueGameInput = readLine();

        if (continueGameInput.equals(CONTINUE_GAME_SIG)) {
            return true;
        }
        if (continueGameInput.equals(END_GAME_SIG)) {
            return false;
        }

        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
    }

    public static List<Integer> inputNumberList() {
        String input = readLine();
        validateIsNumber(input);

        return Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

    }

    private static void validateIsNumber(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
    }
}
