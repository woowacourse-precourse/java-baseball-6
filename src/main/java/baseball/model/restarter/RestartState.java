package baseball.model.restarter;

import java.util.Arrays;

public enum RestartState {

    RESTART_GAME(1, false),
    END_GAME(2, true);

    private int num;
    private boolean flag;

    // private constructor
    RestartState(int num, boolean flag) {
        this.num = num;
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
                .filter(state -> state.num == num)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isEndGame() {
        return this.flag;
    }
}
