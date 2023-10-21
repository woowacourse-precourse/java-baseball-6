package baseball.vo;

import java.util.List;

public final class GameResult {

    private final List<Integer> result;

    public GameResult(List<Integer> result) {
        this.result = result;
    }

    public GameResult makeNewGameResult(List<Integer> result) {
        return new GameResult(result);
    }

    public Integer getStrikeCount() {
        return result.get(0);
    }

    public Integer getBallCount() {
        return result.get(1);
    }
}
