package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Game {
    private static final String FORMAT = "^[1-2]$";
    private static final Pattern PATTERN = Pattern.compile(FORMAT);
    private final Computer computer;
    private final User user;

    public Game() {
        computer = new Computer();
        user = new User();
    }

    public void run() {
        do {
            computer.start();
        } while (canRestart());
    }

    private boolean canRestart() {
        String input = Console.readLine();
        validateInput(input);
        return Integer.parseInt(input) == 1;
    }

    private void validateInput(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
