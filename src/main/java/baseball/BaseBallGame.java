package baseball;

import java.util.List;

public class BaseBallGame {
    RandomNumberPicker randomNumberPicker = new RandomNumberPicker();
    public void play() {
        List<Integer> randomNums = randomNumberPicker.pickRandomNums();
    }
}
