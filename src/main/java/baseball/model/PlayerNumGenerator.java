package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PlayerNumGenerator {
    public List<Integer> playerNum() {
        System.out.println("숫자를 입력해주세요");
        List<Integer> playerNum = new ArrayList<>();
        String input = Console.readLine();

        for (String number : input.split("")) {
            playerNum.add(Integer.parseInt(number));
        }
        Util.LengthException(input);
        Util.DuplicationException(input);

        return playerNum;
    }
}

