package baseball.baseballV2.system.util;

import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static final int VALID_INPUT_SIZE = 3;
    public static final int FIRST_DIGIT = 0;

    public static final String USER_TRIPLE_BALLS_KEY = "userTripleBalls";
    public static final String GAME_RESULT_PATH = "gameResult";
    public static final String GAME_RESTART_CHOICE_KEY = "restartChoice";

    public static List<Character> StringToCharList(String input) {
        return input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toList());
    }
}
