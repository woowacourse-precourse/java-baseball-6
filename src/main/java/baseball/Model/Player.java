package baseball.Model;

import baseball.Utils.CheckValidNumber;
import baseball.Utils.ChangeArray;
import java.util.List;

public class Player {
    public static String playerNumber;
    public static List<Integer> playerNumberList;

    public static void getPlayerNumber(String inputNumber) {
        playerNumber = inputNumber;
        CheckValidNumber.IsValidNumber(inputNumber);
        playerNumberList = ChangeArray.stringToList(inputNumber);
    }
}
