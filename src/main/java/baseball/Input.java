package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public List<Integer> playerNumber() {
        System.out.println("숫자를 입력해주세요 : ");

        try {
            String input = Console.readLine();
            List<Integer> playerNum = new ArrayList<>();

            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }

            for (String number : input.split("")) {
                playerNum.add(Integer.parseInt(number));
            }
            return playerNum;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
