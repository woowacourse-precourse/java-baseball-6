package baseball;

import java.util.List;

public interface Opponent {
    GameResult guess(List<Integer> userGuess);
}
