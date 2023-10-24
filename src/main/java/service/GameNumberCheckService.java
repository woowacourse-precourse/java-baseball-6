package service;

import java.util.ArrayList;
import java.util.List;

public class GameNumberCheckService {
    private static final int NUMBER_SIZE = 3;
    private int countStrike;
    private int countBall;

    private List<Integer> countStrikeBallList = new ArrayList<>();

    public List<Integer> compareGameNumber(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        resetCountStrikeBall();
        setcountStrikeBallList(getcountStrike(playerNumbers, computerNumbers),
                getcountBall(playerNumbers, computerNumbers));
        return countStrikeBallList;
    }

    public void setcountStrikeBallList(int countStrike, int countBall) {
        countStrikeBallList.add(countStrike);
        countStrikeBallList.add(countBall);
    }

    public int getcountStrike(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        countStrike(playerNumbers, computerNumbers);
        return countStrike;
    }

    public void countStrike(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (Strike(playerNumbers.get(i), computerNumbers.get(i))) {
                countStrike++;
            }
        }
    }

    public boolean Strike(int playerNumbers, int computerNumber) {
        if (playerNumbers == computerNumber) {
            return true;
        }
        return false;
    }

    public int getcountBall(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        countBall(playerNumbers, computerNumbers);
        return countBall;
    }

    public void countBall(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (computerNumbers.contains(playerNumbers.get(i)) && computerNumbers.get(i) != playerNumbers.get(i)) {
                countBall++;
            }
        }
    }

    public void resetCountStrikeBall() {
        countStrikeBallList.clear();
        countStrike = 0;
        countBall = 0;
    }
}
