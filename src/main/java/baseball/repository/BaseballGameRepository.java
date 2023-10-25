package baseball.repository;

import baseball.domain.BaseballGame;

public class BaseballGameRepository {
    private static BaseballGame baseballGame;

    public static void save(BaseballGame baseballGame) {
        BaseballGameRepository.baseballGame = baseballGame;
    }

    public static BaseballGame find() {
        return BaseballGameRepository.baseballGame;
    }
}