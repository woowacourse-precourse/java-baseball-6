package baseball.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public static void validateInteger(String playerNumStr) {
        if (!playerNumStr.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public static void validateLength(List<Integer> playerNumList, int numSize) {
        if (playerNumList.size() != numSize) {
            throw new IllegalArgumentException("[ERROR] " + numSize + "자리 숫자를 입력해 주세요.");
        }
    }

    public static void validateRange(List<Integer> playerNumList, int startNum, int endNum) {
        for (int playerNum : playerNumList) {
            if (playerNum < startNum || playerNum > endNum) {
                throw new IllegalArgumentException("[ERROR] " + startNum + "~" + endNum + "사이의 숫자를 입력해 주세요");
            }
        }
    }

    public static void validateRange(int reGameOrExitNum, int startNum, int endNum) {
        if (reGameOrExitNum < startNum || reGameOrExitNum > endNum) {
            throw new IllegalArgumentException("[ERROR] " + startNum + "~" + endNum + "사이의 숫자를 입력해 주세요");
        }
    }

    public static void validateUnique(List<Integer> playerNumList) {
        Set<Integer> playerNumSet = new HashSet<>(playerNumList);

        if (playerNumSet.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력해 주세요");
        }
    }
}
