package others;

import static others.Constant.numberOfNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public static String playerInputGuessingNumber() {
        return Console.readLine().trim().replaceAll(" ", "");
    }

    public static List<Integer> playerGenerateNum(final String strNumber) {
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < numberOfNumbers; i++) {
            int intNumber = strNumber.charAt(i) - '0';
            player.add(intNumber);
        }
        return player;
    }

    public static String playerInputRestartNumber() {
        return Console.readLine().trim().replaceAll(" ", "");
    }
}
