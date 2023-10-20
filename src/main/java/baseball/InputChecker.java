package baseball;

import java.util.List;

public class InputChecker {

    public static void checkValidNumber(List<Integer> playerInputList) {
        if (playerInputList.size() != 3) {
            throw new IllegalArgumentException();
        } else if (playerInputList.size() != playerInputList.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
