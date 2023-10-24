package baseball;

import java.util.Arrays;
import java.util.List;

// 일급 컬렉션
public class Balls {

    private final List<Ball> ballList;

    public Balls(List<Integer> integerList) {

        this.ballList = Arrays.asList(
                new Ball(integerList.get(0), 1),
                new Ball(integerList.get(1), 2),
                new Ball(integerList.get(2), 3)
        );
    }

    public String compare(Balls otherBalls) {
        BallStatusRecord statusRecord = new BallStatusRecord();
        
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                statusRecord.record(ballList.get(i).compare(otherBalls.ballList.get(k)));
            }
        }

        return statusRecord.getResult();
    }
}
