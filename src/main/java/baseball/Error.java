package baseball;

import java.util.Arrays;
import java.util.List;

public class Error extends Throwable {
    final public static int CONTINUE_GAME = 1;
    final public static int END_GAME = 2;
    final public static List<Integer> GAME_STATE = Arrays.asList(CONTINUE_GAME,END_GAME);
}
