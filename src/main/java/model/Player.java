package model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Player {
    private final Set<Integer> playerBall = new LinkedHashSet<>();

    public void generateBalls(String balls) {
        for (int ballIndex = 0; ballIndex < balls.length(); ballIndex++) {
            int uniqueNumber = balls.charAt(ballIndex) - '0';
            playerBall.add(uniqueNumber);
        }
    }

    public void initPlayerBall() {
        playerBall.clear();
    }

    public Set<Integer> getPlayerNumber() {
        return playerBall;
    }
}