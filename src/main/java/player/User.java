package player;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User extends BaseballPlayer {
    @Override
    public void inputBaseballNumbers() {
        List<BaseballNumber> playerInputBaseballNumber = new ArrayList<>();
        String[] playerInput = Console.readLine().split("");

        for (String inputNumber : playerInput) {
            playerInputBaseballNumber.add(new BaseballNumber(inputNumber));
        }

        super.baseballNumbers = new BaseballNumbers(playerInputBaseballNumber);
    }
}
