package baseball.Model;

import baseball.Util.RandomNumberGenerator;

import java.util.List;
import java.util.Map;

public class GameService {

    Balls computerBalls;

    public void readyGame() {
        computerBalls = new Balls(RandomNumberGenerator.generateRandomThreeNumber());
    }

    public Map<String,Integer> playRound(List<Integer> inputNumbers) {
        Referee referee = new Referee();
        Balls userBalls = new Balls(inputNumbers);

        return referee.judge(userBalls, computerBalls);
    }
}
