package baseball.Service;

import static baseball.util.Constants.BALL_KEY;
import static baseball.util.Constants.MAX_NUMBER;
import static baseball.util.Constants.MIN_NUMBER;
import static baseball.util.Constants.NUMBER_SIZE;
import static baseball.util.Constants.STRIKE_KEY;

import baseball.model.Computer;
import baseball.util.Random;
import java.util.HashMap;
import java.util.List;

public class ComputerService {
    private Computer computer;
    private Random random = new Random();

    public void init() {
        List<Integer> answer = random.createRandomNumberList(NUMBER_SIZE, MIN_NUMBER, MAX_NUMBER);
        computer = new Computer(answer);
    }

    public HashMap<Integer, Integer> compareAnswer(List<Integer> userList) {
        int strike = 0;
        int ball = 0;
        HashMap<Integer, Integer> resultMap = new HashMap<>();

        for (int index = 0; index < userList.size(); index++) {
            int temp = userList.get(index);
            if (computer.isContain(temp) && computer.isSameDigit(index, temp)) {
                strike++;
            }
            if (computer.isContain(temp) && !computer.isSameDigit(index, temp)) {
                ball++;
            }
        }
        resultMap.put(STRIKE_KEY, strike);
        resultMap.put(BALL_KEY, ball);
        return resultMap;
    }
}
