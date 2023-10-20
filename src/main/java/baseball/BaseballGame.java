package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private int pointer, strike, ball;
    List<Integer> result = new ArrayList<>();

    public void strikeZone(User user, Computer computer) {
        pointer = 0;
        strike = 0;
        ball = 0;
        for (char num : user.getUserSelectNum().toCharArray()) {
            int value = Character.getNumericValue(num);
            if (value == computer.getRandomComputerPickNum().get(pointer)) {
                strike++;
                pointer++;
                continue;
            }
            if (computer.getRandomComputerPickNum().contains(value)) {
                ball++;
                pointer++;
                continue;
            }
        }
        result.add(ball);
        result.add(strike);
    }
}
