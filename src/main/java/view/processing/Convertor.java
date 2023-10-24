package view.processing;

import static utils.GameConstant.BALL;
import static utils.GameConstant.NOTHING;
import static utils.GameConstant.STRIKE;

import java.util.ArrayList;
import java.util.List;

public final class Convertor {

    public Convertor() {
    }

    public List<Integer> inputToBaseballNumber(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            int number = Character.getNumericValue(c);
            numbers.add(number);
        }
        return numbers;
    }

    public String ballCountToHint(int strike, int ball) {
        StringBuilder builder = new StringBuilder();
        if (ball > 0) {
            builder.append(ball).append(BALL);
            if (strike > 0) {
                builder.append(" ");
            }
        }
        if (strike > 0) {
            builder.append(strike).append(STRIKE);
        }
        if (builder.isEmpty()) {
            builder.append(NOTHING);
        }
        return builder.toString();
    }
}
