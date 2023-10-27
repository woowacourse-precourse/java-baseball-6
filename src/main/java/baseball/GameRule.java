package baseball;

import java.util.List;

public interface GameRule {
    GameStatus determineGameStatus(List<Integer> botNumbers, List<Integer> playerNumbers);
}
