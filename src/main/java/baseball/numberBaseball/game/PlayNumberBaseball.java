package baseball.numberBaseball.game;

public interface PlayNumberBaseball {
    void playGame();

    boolean gameOver();

    boolean gameRestart(String replayInput) throws IllegalArgumentException;

    void gamePlaying(String num) throws IllegalArgumentException;

    String gameResult();
}
