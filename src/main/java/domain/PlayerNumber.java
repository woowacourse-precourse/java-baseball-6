package domain;

import java.util.Arrays;
import java.util.List;

public class PlayerNumber {
    private static String playerNumbers;
    public static boolean isWin = false;

    public void setPlayerNumbers(String number) {
        this.playerNumbers = number;
    }

    public List<Integer> getPlayerNumberToList() {
        return Arrays.stream(playerNumbers.split("")).toList()
                .stream().mapToInt(Integer :: parseInt)
                .boxed()
                .toList();
    }
}
