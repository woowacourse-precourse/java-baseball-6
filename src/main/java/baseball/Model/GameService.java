package baseball.Model;

import java.util.List;
import java.util.Map;

public class GameService {

    Computer computer;
    Referee referee;

    public void readyGame() {
        computer = new Computer();
    }

    public Map<String,Integer> playRound(List<Integer> inputNumbers) {
        referee = new Referee();
        Numbers computerNumbers = computer.getNumbers();
        Numbers userNumbers = new Numbers(inputNumbers);

        return referee.judge(userNumbers, computerNumbers);
    }
}
