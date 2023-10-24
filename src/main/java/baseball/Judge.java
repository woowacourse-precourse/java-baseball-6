package baseball;

import java.util.List;

public class Judge {
    public static Result judge(Balls computerBalls, Balls userBalls, int BallsLength) {
        int strikeCount = 0;
        int ballCount = 0;
        List<Ball> computerBallList = computerBalls.getBallList();
        List<Ball> userBallList = userBalls.getBallList();

        for (int computerBallIndex = 0; computerBallIndex < BallsLength; computerBallIndex++) {
            for (int userBallIndex = 0; userBallIndex < BallsLength; userBallIndex++) {
                Ball tempComputerBall = computerBallList.get(computerBallIndex);
                Ball tempUserBall = userBallList.get(userBallIndex);
                if (tempComputerBall.equals(tempUserBall)) {
                    if (computerBallIndex == userBallIndex) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }

            }
        }
        return new Result(strikeCount, ballCount);
    }
}
