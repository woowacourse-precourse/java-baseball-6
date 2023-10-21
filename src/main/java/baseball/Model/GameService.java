package baseball.Model;

import java.util.List;
import java.util.Map;

public class GameService {

    Computer computer;
    User user;
    Referee referee;

    public void readyGame() {
        computer = new Computer();
    }

    public Map<String,Integer> playRound(List<Integer> inputNumbers) {
        user = new User(inputNumbers);
        referee = new Referee();
        Numbers computerNumbers = computer.getNumbers();
        Numbers userNumbers = user.getNumbers();

        referee.judge(userNumbers, computerNumbers);
        return referee.getJudgement();
    }
}
