package baseball;

import java.util.List;

public class InputChecker {

    public static void checkValidNumber(List<Integer> playerInputList) {
        if (playerInputList.size() != 3) {
            throw new IllegalArgumentException();
        } else if (playerInputList.size() != playerInputList.stream().distinct().count()) {
            throw new IllegalArgumentException();
        } else if (isContainNotNumber(playerInputList)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isContainNotNumber(List<Integer> playerInputList) {
        for (Integer num : playerInputList) {
            if (num < 0 || num > 9) {
                return true;
            }
        }
        return false;
    }
}
