package baseball.game;

import baseball.Constants;
import java.util.List;
import java.util.stream.IntStream;

public class CalculateScore {

    private static int countContains(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return (int) computerNumbers.stream()
                .filter(userNumbers::contains)
                .count();
    }

    public static int countStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return (int) IntStream.range(0, Constants.BASEBALL_NUMBER_SIZE)
                .filter(i -> computerNumbers.get(i).equals(userNumbers.get(i)))
                .count();
    }

    public static int countBall(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return countContains(computerNumbers, userNumbers) - countStrike(computerNumbers,
                userNumbers);
    }

}
