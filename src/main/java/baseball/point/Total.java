package baseball.point;

import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;

public class Total {

    public String printPoint(int[] pointList) {
        int sum = Arrays.stream(pointList).sum();
        if (sum == 0) {
            return "낫싱";
        }
        return checkBallAndStrike(pointList);
    }

    public String checkBallAndStrike(int[] pointList) {
        if (pointList[0] != 0 && pointList[1] != 0) {
            return pointList[0] + "볼 " + pointList[1] + "스트라이크";
        }
        return zeroBallOrStrike(pointList);
    }

    public String zeroBallOrStrike(int[] pointList) {
        if (pointList[0] == 0) {
            return pointList[1] + "스트라이크";
        }
        return pointList[0] + "볼";
    }
}
