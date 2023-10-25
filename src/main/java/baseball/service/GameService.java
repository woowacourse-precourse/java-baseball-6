package baseball.service;

import baseball.domain.dto.GameResult;
import baseball.domain.gamedata.GameData;

public interface GameService {

    void init();

    GameResult calculateResult(GameData data);
}
