package player;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User implements BaseballNumberInput {

    BaseballNumbers baseballNumbers;

    @Override
    public void inputBaseballNumbers() {
        List<BaseballNumber> playerInputBaseballNumber = new ArrayList<>();
        String[] playerInput = Console.readLine().split("");

        for (String inputNumber : playerInput) {
            BaseballNumber baseballNumber = new BaseballNumber(inputNumber);
            playerInputBaseballNumber.add(baseballNumber);
        }

        baseballNumbers = new BaseballNumbers(playerInputBaseballNumber);
    }

}
