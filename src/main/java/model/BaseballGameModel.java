package model;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameModel {
    public List<Integer> compareComputerAndUserNumbers(List<Integer> computer, List<Integer> userNumbers) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computer.get(i))) {
                strikeCount++;
            } else if (computer.contains(userNumbers.get(i))) {
                ballCount++;
            }
        }

        List<Integer> countStrikeAndBall = new ArrayList<>();
        countStrikeAndBall.add(strikeCount);
        countStrikeAndBall.add(ballCount);

        return countStrikeAndBall;
    }
}
