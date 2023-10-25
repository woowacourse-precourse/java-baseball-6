package baseball;

import java.util.List;

public class Player {
    public static String playerNum;

    public static List<Integer> getPlayerNumber(String inputNum){
        playerNum = inputNum;
        // 유효한지 체크
        CheckValidNum.IsValidNum(inputNum);

        // String으로 받은 input Intger
        return ChangeArray.stringToList(inputNum);
    }
}
