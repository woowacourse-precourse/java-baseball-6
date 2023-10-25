package baseball.controller.input;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.exception.WrongInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    private Converter() {
    }

    private static class ConverterHelper {
        private static final Converter INSTANCE = new Converter();
    }

    public static Balls convert(String userInput) {
        return ConverterHelper.INSTANCE.run(userInput);
    }

    public Balls run(String userInput) {
        String[] splitNumbers = userInput.split("");

        List<Ball> ballList = convertToBallList(splitNumbers);
        return new Balls(ballList);
    }

    private List<Ball> convertToBallList(String[] splitNumbers) {
        List<Ball> ballList = new ArrayList<>();

        Arrays.stream(splitNumbers)
                .map(this::parseToBall)
                .forEach(ballList::add);

        return ballList;
    }

    private Ball parseToBall(String numberString) {
        try {
            int number = Integer.parseInt(numberString);
            return new Ball(number);
        } catch (NumberFormatException e) {
            throw new WrongInputException("숫자만 입력해주세요.");
        }
    }
}