package baseball;

import java.util.List;
import java.util.Map;

public class BaseballGame {
    private final List<Integer> computerNumbers;
    public BaseballGame(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }
    public void playBaseballGame() {
        User user = new User();
        List<Integer> userNumbers = user.createUserNumbers();
        Map<String, Integer> gameScore = CalculateScore.gameScore(computerNumbers, userNumbers);
        GameResult gameResult = new GameResult(gameScore.get("ball"), gameScore.get("strike"));
        gameResult.printResult();
        if (!gameResult.isThreeStrike()) {
            playBaseballGame();
        }
    }

}
