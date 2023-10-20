package baseball;

import java.util.stream.Stream;

public class BallArray {
    private final int[] ballArr;

    public BallArray(int number) {
        ballArr = Stream.of(String.valueOf(number)
                        .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public BallResult compareWith(BallArray BallArray) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < ballArr.length; i++) {
            if (BallArray.ballArr[i] == this.ballArr[i]) {
                strikeCount++;
            } else {
                for (int j = 0; j < ballArr.length; j++) {
                    if (j != i && BallArray.ballArr[i] == this.ballArr[j]) {
                        ballCount++;
                    }
                }
            }
        }

        return new BallResult(ballCount,strikeCount);
    }
}
