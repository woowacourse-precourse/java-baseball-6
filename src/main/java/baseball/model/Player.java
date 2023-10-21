package baseball.model;

import baseball.validation.PlayerValidation;

import java.util.List;

public class Player {

    private List<Integer> playerNumber;

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }

    public void inputPlayerNumber(String numbers){
        playerNumber = PlayerValidation.checkNumber(numbers);
    }
}
