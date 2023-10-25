package baseball.player.utils;

import java.util.Arrays;
import java.util.List;

public enum PlayerInputUtils {
    UTILS;

    public List<Integer> convertInputToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
