package baseball;

import java.util.stream.IntStream;

public class BallArray {
    private final Integer[] ballArr;

    public BallArray(Integer... number) {
        ballArr = number;
    }

    public BallResultDto compareWith(BallArray ballArray) {
        return new BallResultDto(calculateBalls(ballArray),calculateStrikes(ballArray));
    }

    private int calculateStrikes(BallArray ballArray) {
        return (int) IntStream.range(0, ballArr.length)
                .filter(i -> this.ballArr[i].equals(ballArray.ballArr[i]))
                .count();
    }

    private int calculateBalls(BallArray ballArray) {
        return (int) IntStream.range(0, ballArr.length)
                .filter(i -> IntStream.range(0, ballArr.length)
                        .anyMatch(j -> j != i && this.ballArr[j].equals(ballArray.ballArr[i])))
                .count();
    }
}
