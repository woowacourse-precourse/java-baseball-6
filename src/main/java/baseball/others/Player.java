package baseball.others;

import static baseball.others.Constant.NUMBER_OF_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public static List<Integer> playerGenerateNum(final String strNumber) {
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_NUMBERS; i++) {
            int intNumber = strNumber.charAt(i) - '0';
            player.add(intNumber);
        }
        return player;
    }

    public static String playerInputNumber() {
        String inputNumber = Console.readLine();
        return inputNumber.trim().replaceAll(" ", "");
    }
}