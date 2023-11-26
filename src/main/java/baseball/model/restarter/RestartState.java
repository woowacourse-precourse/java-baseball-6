package baseball.model.restarter;

import java.util.Arrays;
import java.util.function.Function;

public enum RestartState {

    RESTART_GAME(input -> input == 1, false),
    END_GAME(input -> input == 2, true);

    private Function<Integer, Boolean> function;
    private boolean flag;

    // private constructor
    RestartState(Function<Integer, Boolean> function, boolean flag) {
        this.function = function;
        this.flag = flag;
    }

    // exception handler
    private static void validateIsNumeric(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException();
        }
    }

    // utility
    public static RestartState findState(String input) {
        validateIsNumeric(input);
        int num = Integer.parseInt(input);
        return Arrays.stream(values())
                .filter(state -> state.function.apply(num))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isEndGame() {
        return this.flag;
    }
}
