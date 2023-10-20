package baseball.service;

import java.util.List;

public class GameService {

    private final List<Integer> gameRandomNumbers;

    public GameService(List<Integer> gameRandomNumbers) {
        this.gameRandomNumbers = gameRandomNumbers;
    }

}
