package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {
    public static List<Integer> getPlayerNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumStr = Console.readLine();
        validateInteger(playerNumStr);
        List<Integer> playerNumList = new ArrayList<>();
        playerNumList = stringToIntegerList(playerNumStr);
        validateLength(playerNumList,3);
        validateRange(playerNumList,1,9);
        validateUnique(playerNumList);
        return playerNumList;
    }

    public static int getReGameOrExitNum() {
        String reGameOrExitStr = Console.readLine();
        validateInteger(reGameOrExitStr);
        int reGameOrExitNum = stringToInt(reGameOrExitStr);
        validateRange(reGameOrExitNum, 1, 2);
        return reGameOrExitNum;
    }
    private static void validateInteger(String playerNumStr) {
        if (!playerNumStr.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private static int stringToInt(String reGameOrExitStr) {
        return Integer.parseInt(reGameOrExitStr);
    }
    private static List<Integer> stringToIntegerList(String playerNumStr) {
        List<Integer> playerNumList = new ArrayList<>();
        for (int i=0; i<playerNumStr.length(); i++) {
            playerNumList.add(Character.getNumericValue(playerNumStr.charAt(i)));
        }
        return playerNumList;
    }

    private static void validateLength(List<Integer> playerNumList, int numSize) {
        if (playerNumList.size() != numSize) {
            throw new IllegalArgumentException("[ERROR] "+numSize+"자리 숫자를 입력해 주세요.");
        }
    }

    private static void validateRange(List<Integer> playerNumList, int startNum, int endNum) {
        for (int playerNum : playerNumList) {
            if (playerNum < startNum || playerNum > endNum) {
                throw new IllegalArgumentException("[ERROR] " + startNum + "~" + endNum + "사이의 숫자를 입력해 주세요");
            }
        }
    }

    private static void validateRange(int reGameOrExitNum, int startNum, int endNum) {
        if (reGameOrExitNum < startNum || reGameOrExitNum > endNum) {
            throw new IllegalArgumentException("[ERROR] " + startNum + "~" + endNum + "사이의 숫자를 입력해 주세요");
        }
    }

    private static void validateUnique(List<Integer> playerNumList) {
        Set<Integer> playerNumSet = new HashSet<>(playerNumList);

        if (playerNumSet.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력해 주세요");
        }
    }
}
