package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class StartGame {
    public List<Integer> playerNum() {
        System.out.println("숫자를 입력해주세요");
        List<Integer> playerNum = new ArrayList<>();
        String input = Console.readLine();

        for (String number : input.split("")) {
            playerNum.add(Integer.parseInt(number));
        }
        LengthException(input);

        return playerNum;
    }

    public void LengthException(String s) {
        if (s.length() != 3) {
            throw new IllegalArgumentException("세자리 수를 입력해주세요.");
        }
    }
}

