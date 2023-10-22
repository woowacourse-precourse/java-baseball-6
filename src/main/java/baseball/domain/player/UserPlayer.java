package baseball.domain.player;

import baseball.utils.StringUtil;
import camp.nextstep.edu.missionutils.Console;
public class UserPlayer {
    private static int SIZE = 3;
    public static int[] userNum = new int[SIZE];

    public static void setUserNumber() {
        String userString = Console.readLine();
        int[] userNum = StringUtil.stringToIntArray(userString);
    }
    public static int[] getUserNumber() {
        return userNum;
    }
}

