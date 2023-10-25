package baseball.model;

import baseball.model.ball.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer extends BaseballGameRule{

    Balls balls;

    public List<Integer> pickNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BASEBALL_MAX_AMOUNT) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_MIN_VALUE, BASEBALL_MAX_VALUE);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public Balls initBallsForGame(List<Integer> numbers) {
        balls = new Balls(numbers);
        return balls;
    }
}
