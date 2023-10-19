package baseball.service;

import baseball.domain.GameResult;
import baseball.domain.GameData;

public interface GameService {

    void init();

    GameResult calculateResult(GameData data);
}
