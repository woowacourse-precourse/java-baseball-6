package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> playerBall = new ArrayList<>();

    public void initPlayerBall(int inputValue) {
        while(inputValue != 0) {
            int value = inputValue % 10;
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
