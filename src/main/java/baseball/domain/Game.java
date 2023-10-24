package baseball.domain;

public class Game {

    int[] gameNumber;
    int strike;
    int ball;

    public Game(int[] number) {
        gameNumber = number;
        strike = 0;
        ball = 0;
    }
}