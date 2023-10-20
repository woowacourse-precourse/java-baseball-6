package baseball;

import java.util.List;
import java.util.Map;

public class BaseballGame {
    private static BaseballNumbers numbers = new BaseballNumbers();
    private static List<Integer> computerNumbers = numbers.createComputerNumbers();
    public void play(List<Integer> userNumbers) {
        System.out.println(computerNumbers);
        Map<String, Integer> gameScore = CalculateScore.gameScore(computerNumbers, userNumbers);
        GameResult gameResult = new GameResult(gameScore.get("ball"), gameScore.get("strike"));
        gameResult.printResult();
        if (!gameResult.isStrike()) {
            userNumbers = numbers.createUserNumbers();
            play(userNumbers);
        }
    }

}
