package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

// 2. 사용자 입력 받기
public class PlayerInputNumber {
    public List<Integer> inputNumber() {
        String input = Console.readLine();

        List<Integer> playerNum = new ArrayList<>();

        for (String number : input.split("")) {
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }
}
