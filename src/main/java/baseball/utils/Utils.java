package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public List<Integer> convertStringToIntList(String input) {
        List<Integer> playerNumber = new ArrayList<>();

        for (String number : input.split("")) {
            playerNumber.add(Integer.parseInt(number));
        }

        return playerNumber;
    }
}
