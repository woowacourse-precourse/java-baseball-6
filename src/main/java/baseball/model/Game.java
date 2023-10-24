package baseball.model;

public class Game {

    int[] gameNumber;
    int strike;
    int ball;

    public Game(int[] number) {
        gameNumber = number;
    }

    public void initGame() {
        strike = 0;
        ball = 0;
    }

    public int[] getGameNumber() {
        return gameNumber;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }
}