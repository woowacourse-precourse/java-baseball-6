package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Referee {
    boolean isNothing(Set<Integer> computerBalls, Set<Integer> playerBalls) {
        for (int playerBall: playerBalls) {
            if (computerBalls.contains(playerBall)) {
                return false;
            }
        }
        return true;
    }

    int countStrike(Set<Integer> computerBalls, Set<Integer> playerBalls) {
        int strikeCount = 0;
        for (int index = 0; index < computerBalls.size(); index++) {
            List<Integer> computerBall = new ArrayList<Integer>(computerBalls);
            List<Integer> playerBall = new ArrayList<Integer>(playerBalls);

            if (computerBall.get(index) == playerBall.get(index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}