package baseball.domain.player;

import baseball.utils.StringException;
import baseball.utils.StringUtil;
import camp.nextstep.edu.missionutils.Console;
public class UserPlayer {

    public static String userString;

    public static void setUserNumber() {
        String userString = Console.readLine();
        userString.replaceAll("\\s+", "").trim();
    }
    public static String getUserNumber() {
        return userString;
    }
}

