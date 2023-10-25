package baseball;

import java.util.ArrayList;

public class BallBucket {
    private final ArrayList<Ball> Balls;
    public static final int BUCKET_SIZE = 3;

    public BallBucket(ArrayList<Ball> balls) {
        this.Balls = new ArrayList<>();
        for (int i = 0; i < BallBucket.BUCKET_SIZE; i++) {
            this.Balls.add(balls.get(i));
        }
    }

    public int compareBalls(Object obj) {

        if (!(obj instanceof BallBucket ballBucket)) {
            throw new RuntimeException("서로 다른 객체를 비교할 수 없습니다.");
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    if (ballBucket.Balls.get(i).equals(this.Balls.get(j))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int compareStrike(Object obj) {

        if (!(obj instanceof BallBucket ballBucket)) {
            throw new RuntimeException("서로 다른 객체를 비교할 수 없습니다.");
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (ballBucket.Balls.get(i).equals(this.Balls.get(i))) {
                count++;
            }
        }
        return count;
    }

}


