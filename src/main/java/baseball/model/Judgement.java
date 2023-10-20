package baseball.model;

import static baseball.model.Result.BALL;
import static baseball.model.Result.STRIKE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Judgement {

    public Map<Result, Integer> judge(Computer computer, Player player) {
        Map<Result, Integer> gameResult = new HashMap<>();

        List<Integer> playerNumbers = player.getNumbers();
        for (int i = 0; i < playerNumbers.size(); i++) {
            int number = playerNumbers.get(i);

            if (computer.hasNumber(number)) {
                if (computer.isSameIndex(number, i)) {
                    gameResult.put(STRIKE, gameResult.getOrDefault(STRIKE, 0) + 1);
                    continue;
                }
                gameResult.put(BALL, gameResult.getOrDefault(BALL, 0) + 1);
            }
        }

        return gameResult;
    }
}
