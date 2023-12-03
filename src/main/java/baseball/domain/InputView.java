package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<Integer> readPlayerNumber() {
        System.out.println("숫자를 입력하세요");
        String player = Console.readLine();
        try {
            Validator.validateNumber(player);
            return makeNumberArray(player);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> makeNumberArray(String player) {
        List<Integer> playerNum = new ArrayList<>();

        for (int i=0; i<player.length(); i++) {
            String eachNum = Character.toString(player.charAt(i));
            int num = Integer.parseInt(eachNum);
            playerNum.add(num);
        }
        Validator.duplicated(playerNum);
        return playerNum;
    }

}
