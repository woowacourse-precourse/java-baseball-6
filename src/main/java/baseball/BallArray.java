package baseball;

public class BallArray {
    private final Integer[] ballArr;

    public BallArray(Integer... number) {
        ballArr = number;
    }

    public BallResult compareWith(BallArray BallArray) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < ballArr.length; i++) {
            if ( ballArr[i].equals(BallArray.ballArr[i])) {
                strikeCount++;
            } else {
                for (int j = 0; j < ballArr.length; j++) {
                    if (j != i && ballArr[j].equals(BallArray.ballArr[i])) {
                        ballCount++;
                    }
                }
            }
        }

        return new BallResult(ballCount,strikeCount);
    }
}
