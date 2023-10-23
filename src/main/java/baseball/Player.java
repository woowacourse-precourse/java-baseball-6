package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> playerBall = new ArrayList<>();

    public void initPlayerBall(int inputValue) throws IllegalArgumentException {
        if((inputValue / 100) < 1 || (inputValue / 100) > 9) {
            throw new IllegalArgumentException();
        }
        while(inputValue != 0) {
            int value = inputValue % 10;
            isDuplicateNumOrContainZero(value);
            playerBall.add(0, value);
            inputValue /= 10;
        }
    }

    public Player(String inputValue) throws IllegalArgumentException{
        isNullOrContainNotInt(inputValue);
        int inputValueToInt = Integer.parseInt(inputValue);
        initPlayerBall(inputValueToInt);
    }

    public void isDuplicateNumOrContainZero(int value) {
        if(playerBall.contains(value) || value == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void isNullOrContainNotInt(String inputValue) {
        if(inputValue == null || !inputValue.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getPlayerBall() {
        return playerBall;
    }
}
