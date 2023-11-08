package refactor.domain;


import refactor.dto.Score;

import java.util.List;

public class Game {

    private Score score = new Score(0, 0);

    public Game() {};

    public void resetScore() {
        score = new Score(0, 0);
    }

    public void calculateScore(List<Integer> computer, List<Integer>user) {
        for(int i = 0; i < 3; i++) {
            int selectNumber = user.get(i);
            increaseStrikeOrBall(i, computer, selectNumber);
        }
    }

    private void increaseStrikeOrBall(int digit, List<Integer> computer, int selectNumber) {

        if(computer.get(digit) == selectNumber) {
            score.setStrike(score.getStrike() + 1);
            return;
        }

        if(computer.contains(selectNumber)) {
            score.setBall(score.getBall() + 1);
        }
    }

    public Score getScore() {
        return score;
    }

    public boolean threeStrikeCheck() {
        return score.getStrike() == 3;
    }

}
