package baseball.utils;

import baseball.domain.Ball;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Converter {

    private static final int BASE_DIVISOR = 10;

    public static String convertBallListToString(List<Ball> ballList) {
        ballList.sort(Comparator.comparingInt(Ball::getPosition));

        StringBuilder stringBuilder = new StringBuilder();
        for (Ball ball : ballList) {
            stringBuilder.append(ball.getValue());
        }

        return stringBuilder.toString();
    }

    public static List<Ball> extractDigitsFromNumber(int number) {
        List<Ball> extractedDigits = new ArrayList<>();
        int position = 0;
        while (number != 0) {
            extractedDigits.add(new Ball(number % BASE_DIVISOR, position));
            number /= BASE_DIVISOR;
            position++;
        }
        return extractedDigits;
    }
}
