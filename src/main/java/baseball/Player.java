package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> playerBall = new ArrayList<>();

    public void initPlayerBall(int inputValue) {

        while(inputValue != 0) {
            playerBall.add(0, inputValue % 10);
            inputValue/= 10;
        }
    }

    public Player(int inputValue) {
        initPlayerBall(inputValue);
    }

    public List<Integer> getPlayerBall() {
        return playerBall;
    }
}
