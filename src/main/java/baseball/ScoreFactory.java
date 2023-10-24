package baseball;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class ScoreFactory {

    public static Score calculateScore(List<Integer> randomNumber, List<Integer> userNumber) {
        int strikeCount = (int) IntStream.range(0, randomNumber.size())
                .filter(i -> randomNumber.get(i).equals(userNumber.get(i)))
                .count();

        int ballCount = (int) userNumber.stream()
                .filter(userDigit -> randomNumber.contains(userDigit) && !Objects.equals(randomNumber.indexOf(userDigit), userNumber.indexOf(userDigit)))
                .count();

        return new Score(strikeCount, ballCount);
    }

}