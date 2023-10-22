package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public Player() {}

    public List<Integer> setNumber() {
        List<Integer> playerNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String element = Console.readLine();
        System.out.println(element);
        String[] stringNumber = element.split("");
        for (String number : stringNumber) {
            playerNumber.add(Integer.parseInt(number));
        }
        return playerNumber;
    }
}
