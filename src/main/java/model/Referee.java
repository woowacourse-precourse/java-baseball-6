package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Referee {
    public static void judgeValue(Set<Integer> computerBalls, Set<Integer> playerBalls) {
        String gameResult = "";
        if (isNothing(computerBalls, playerBalls)) {
            gameResult = "낫싱";
        }

        int strikeNumber = countStrike(computerBalls, playerBalls);
        int ballNumber = countBall(computerBalls, playerBalls);

        if (ballNumber > 0) {
            gameResult += ballNumber + "볼 ";
        }

        if (strikeNumber > 0) {
            gameResult += strikeNumber + "스트라이크";
        }
    }

    static boolean isNothing(Set<Integer> computerBalls, Set<Integer> playerBalls) {
        for (int playerBall: playerBalls) {
            if (computerBalls.contains(playerBall)) {
                return false;
            }
        }
        return true;
    }

    static int countStrike(Set<Integer> computerBalls, Set<Integer> playerBalls) {
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

    static int countBall(Set<Integer> computerBalls, Set<Integer> playerBalls) {
        int ballNumber = 0;
        for (int index = 0; index < computerBalls.size(); index++) {
            List<Integer> computerBall = new ArrayList<Integer>(computerBalls);
            List<Integer> playerBall = new ArrayList<Integer>(playerBalls);

            if (!computerBall.contains(playerBall.get(index))) {
                continue;
            }

            if (computerBall.get(index) != playerBall.get(index)) {
                ballNumber++;
            }
        }
        return ballNumber;
    }
}