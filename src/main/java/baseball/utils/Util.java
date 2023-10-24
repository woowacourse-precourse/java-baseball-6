package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {

    public static int stringToInt(String reGameOrExitStr) {
        return Integer.parseInt(reGameOrExitStr);
    }
    public static List<Integer> stringToIntegerList(String playerNumStr) {
        List<Integer> playerNumList = new ArrayList<>();
        for (int i=0; i<playerNumStr.length(); i++) {
            playerNumList.add(Character.getNumericValue(playerNumStr.charAt(i)));
        }
        return playerNumList;
    }
}
