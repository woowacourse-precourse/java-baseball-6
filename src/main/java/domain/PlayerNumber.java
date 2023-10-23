package domain;

import java.util.Arrays;
import java.util.List;

public class PlayerNumber {
    public static List<Integer> playerNumbers;
    public static boolean isWin = false;

    public void setPlayerNumbers(String number) {
        this.playerNumbers = Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
