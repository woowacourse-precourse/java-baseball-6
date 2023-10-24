package baseball.utils;

import java.util.ArrayList;
import java.util.List;

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
