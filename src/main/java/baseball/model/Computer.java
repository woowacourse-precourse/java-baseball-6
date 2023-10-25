package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.ComputerNumberGenerator.generateRandomNumbers;

public class Computer {

    private final List<Ball> balls = new ArrayList<>();

    public Computer() {
        changeBalls();
    }

    public void changeBalls() {
        balls.clear();

        List<Integer> numbers = generateRandomNumbers();
        for (int i = 0; i < numbers.size(); i++) {
            balls.add(new Ball(numbers.get(i), i + 1));
        }
    }
}
