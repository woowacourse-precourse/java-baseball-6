package baseball;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.SystemConstant.GAME_DIGIT;


public final class Referee {

    private Referee() {
    }

    public static Score makeScore(List<Integer> userNumber, List<Integer> computerNumber){
        return new Score(
                makeBallCount(userNumber,computerNumber),
                makeStrikeCount(userNumber, computerNumber)
        );
    }

    private static int makeBallCount(List<Integer> userNumber, List<Integer> computerNumber){
        return (int) IntStream.range(0, GAME_DIGIT)
                .filter(i -> userNumber.get(i) != computerNumber.get(i))
                .filter(i -> computerNumber.contains(userNumber.get(i)))
                .count();
    }

    private static int makeStrikeCount(List<Integer> userNumber, List<Integer> computerNumber){
        return (int) IntStream.range(0, GAME_DIGIT)
                .filter(i -> userNumber.get(i) == computerNumber.get(i))
                .count();
    }

}
