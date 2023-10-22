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
            if(playerBall.contains(value)) {
                throw new IllegalArgumentException();
            }
            playerBall.add(0, value);
            inputValue /= 10;
        }
    }

    public Player(int inputValue) {
        initPlayerBall(inputValue);
    }

    public List<Integer> getPlayerBall() {
        return playerBall;
    }
}
