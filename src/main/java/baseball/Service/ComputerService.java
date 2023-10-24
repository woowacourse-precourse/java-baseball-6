package baseball.Service;

import static baseball.util.Constants.ANSWER_SIZE;
import static baseball.util.Constants.MAX_NUMBER;
import static baseball.util.Constants.MIN_NUMBER;

import baseball.model.Player;
import baseball.util.Random;
import java.util.List;

public class ComputerService {
    private final Player computer = new Player();
    private final Random random = new Random();

    public Player init() {
        List<Integer> answer = random.createRandomNumberList(ANSWER_SIZE, MIN_NUMBER, MAX_NUMBER);
        computer.createAnswer(answer);
        return computer;
    }


}
