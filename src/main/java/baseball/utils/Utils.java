package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Integer> convertStringToIntList(String input) {
        List<Integer> playerNumber = new ArrayList<>();
        String[] numbers = input.split("");

        for (String number : numbers) {
            playerNumber.add(Integer.parseInt(number));
        }

        return playerNumber;
    }
}
