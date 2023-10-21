package baseball;

import java.util.List;

public class Player {

    private List<Integer> playerNumber;

    public void setPlayerNumber(String inputNumber) {
        playerNumber = BaseballNumber.generatePlayerNumber(inputNumber);
    }
}
