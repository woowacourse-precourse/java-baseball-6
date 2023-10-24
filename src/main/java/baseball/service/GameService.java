package baseball.service;

import baseball.config.GameConfig;
import baseball.domain.Baseball;
import baseball.domain.GameResult;
import baseball.util.NumberGenerator;
import java.util.List;

public class GameService {

    private static final int WINNING_COUNT = GameConfig.BASEBALL_LENGTH;

    private final NumberGenerator numberGenerator;

    private Baseball computer;
    private Baseball player;

    public GameService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void startGame() {
        this.computer = new Baseball(numberGenerator.generate());
        this.player = new Baseball();
    }

    public void setPlayerBaseball(List<Integer> numbers) {
        player.setNumbers(numbers);
    }

    public GameResult getGameResult() {
        int strikeCount = computer.countSameNumbersByIndex(player);
        if (strikeCount == WINNING_COUNT) {
            return GameResult.allStrike();
        }

        int sameCount = computer.countSameNumbers(player);
        if (sameCount == 0) {
            return GameResult.nothing();
        }

        return GameResult.ballsAndStrikes(sameCount - strikeCount, strikeCount);
    }

    public boolean isGameWon() {
        return this.computer.equals(player);
    }
}
