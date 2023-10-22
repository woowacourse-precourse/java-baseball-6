package baseball;

import java.util.List;

public class Ball {
    String value;
    public Ball(String ball) {
        this.value = ball;
    }

    public Ball(List<Integer> numbers) {
        value = new String();
        for (Integer number : numbers) {
            value += number;
        }
    }
}
