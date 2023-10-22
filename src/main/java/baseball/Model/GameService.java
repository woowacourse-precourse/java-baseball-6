package baseball.Model;

import baseball.Util.RandomNumberGenerator;

import java.util.List;
import java.util.Map;

public class GameService {

    Numbers computerNumbers;
    Numbers userNumbers;
    Referee referee;

    public void readyGame() {
        computerNumbers = new Numbers(RandomNumberGenerator.generateRandomThreeNumber());
    }

    public Map<String,Integer> playRound(List<Integer> inputNumbers) {
        referee = new Referee();
        userNumbers = new Numbers(inputNumbers);

        return referee.judge(userNumbers, computerNumbers);
    }
}
