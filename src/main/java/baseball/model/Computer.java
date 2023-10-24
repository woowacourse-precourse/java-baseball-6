package baseball.model;

import baseball.model.ball.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    Balls balls;
    public List<Integer> pickNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
