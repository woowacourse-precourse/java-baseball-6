package baseball.domain;

import java.util.List;

public class User {

    private final GameIO gameIO;

    public User(GameIO gameIO) {
        this.gameIO = gameIO;
    }

    public List<Integer> guessAnswer(int numberLength) {
        return gameIO.inputGuessAnswer(numberLength);
    }
}
