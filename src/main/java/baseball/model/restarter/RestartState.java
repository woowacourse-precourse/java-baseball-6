package baseball.model.restarter;

import java.util.Arrays;
import java.util.function.Function;

public enum RestartState {

    RESTART_GAME(input -> input == 1),
    END_GAME(input -> input == 2);

    private Function<Integer, Boolean> function;

    // private constructor
    RestartState(Function<Integer, Boolean> function) {
        this.function = function;
    }

    // utility
    public static RestartState findState(int num) {
        return Arrays.stream(values())
                .filter(state -> state.function.apply(num))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
