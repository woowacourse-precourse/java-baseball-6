package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    protected static final String RESTART = "1";
    protected static final String EXIT = "2";

    public static String guess;

    public static void guessInput() {
        String input = Console.readLine();
    }

    public static boolean isRestart() {
        String input = Console.readLine();
        return input.equals(RESTART);
    }
}
