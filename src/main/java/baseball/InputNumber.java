package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    public List<Integer> playerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playerNum = new ArrayList<>();
        String inputNum = Console.readLine();

        for (String number : inputNum.split("")) {
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }
}
