package baseball.Game;

public interface BaseBallGame {

    void initGame();

    void playGame(Integer userAnswer, Integer computerAnswer);

    Integer makeRandomNumber();

    Integer countStrike(Integer answer);

    Integer countBall(Integer answer);

    Boolean isNothing(Integer answer);

    void printResult(Integer strike, Integer ball);

}
