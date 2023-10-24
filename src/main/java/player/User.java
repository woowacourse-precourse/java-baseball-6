package player;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User implements BaseballPlayer {

    private BaseballNumbers baseballNumbers;

    @Override
    public void inputBaseballNumbers() {
        List<Integer> playerInputBaseballNumber = new ArrayList<>();
        String[] playerInput = Console.readLine().split("");

        for (String inputNumber : playerInput) {
            playerInputBaseballNumber.add(Integer.parseInt(inputNumber));
        }

        this.baseballNumbers = new BaseballNumbers(playerInputBaseballNumber);
    }

    @Override
    public List<Integer> getBaseballNumbers() {
        return baseballNumbers.getBaseballNumbers();
    }
}
