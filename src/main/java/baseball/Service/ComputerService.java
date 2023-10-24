package baseball.Service;

import static baseball.util.Constants.ANSWER_SIZE;
import static baseball.util.Constants.MAX_NUMBER;
import static baseball.util.Constants.MIN_NUMBER;

import baseball.model.Player;
import baseball.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ComputerService {
    private Player computer;
    private final Random random = new Random();

    public void init() {
        List<Integer> answer = random.createRandomNumberList(ANSWER_SIZE, MIN_NUMBER, MAX_NUMBER);
        computer = new Player(answer);
    }

    public List<Integer> compareAnswer(List<Integer> userAnswer) {
        List<Integer> resultList = new ArrayList<>();
        for (int index = 0; index < userAnswer.size(); index++) {
            int element = userAnswer.get(index);
            int result = computer.determine(element, index);
            resultList.add(result);
        }
        return resultList;
    }
}
