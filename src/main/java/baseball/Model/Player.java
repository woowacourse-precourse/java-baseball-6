package baseball.Model;

import baseball.Utils.CheckValidNumber;
import baseball.Utils.ChangeArray;
import java.util.List;

public class Player {
    public static String playerNumber;

    public static List<Integer> getPlayerNumber(String inputNumber) {
        playerNumber = inputNumber;
        CheckValidNumber.IsValidNumber(inputNumber);
        return ChangeArray.stringToList(inputNumber);
    }
}
