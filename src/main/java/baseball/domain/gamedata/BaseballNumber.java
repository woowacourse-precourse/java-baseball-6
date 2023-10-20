package baseball.domain.gamedata;

import baseball.domain.BaseballNumberMaker;
import baseball.domain.GameResult;
import java.util.ArrayList;
import java.util.List;

public record BaseballNumber(List<Integer> numbers) implements GameData {

    /**
     *
     * @param numbers Integer list that size is 3. Throw exception if size is not 3.
     */
    public BaseballNumber {
        validateSize(numbers);
    }

    /**
     *
     * @param answer String that size is 3 and composed only num.
     *                Throw exception if size is not 3 or can not convert to int.
     */
    public static BaseballNumber of(final String answer) {
        int number = validateContentType(answer);
        List<Integer> list = convertToList(number, answer.length());
        list = list.stream().distinct().toList();
        validateSize(list);
        return new BaseballNumber(list);
    }

    public GameResult calculateResult(final BaseballNumber answer) {
        int strikeAndBall = countStrikeAndBall(answer.numbers);
        int strike = countStrike(answer.numbers);
        int ball = strikeAndBall - strike;
        return new GameResult(strike, ball);
    }

    private int countStrikeAndBall(final List<Integer> answerNumbers) {
        return (int) this.numbers.stream()
                .filter(answerNumbers::contains)
                .count();
    }

    private int countStrike(final List<Integer> answerNumbers) {
        return (int) this.numbers.stream()
                .filter(n -> isStrike(answerNumbers, n))
                .count();
    }

    private boolean isStrike(final List<Integer> answerNumbers, final Integer n) {
        return answerNumbers.get(this.numbers.indexOf(n)).equals(n);
    }

    private static List<Integer> convertToList(int number, final int length) {
        List<Integer> list = new ArrayList<>(length);
        int ten = 10;
        int value = (int) Math.pow(ten, length - 1); //5의제곱;
        for (int i = 0; i < length; i++) {
            list.add(number / value);
            number %= value;
            value /= ten;
        }
        return list;
    }

    private static int validateContentType(final String numbers) {
        try {
            return Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void validateSize(final List<Integer> numbers) {
        if (numbers.size() != BaseballNumberMaker.COUNT) {
            throw new IllegalArgumentException();
        }
    }
}