package baseball.valueObject;

import java.util.List;

public class BallInfo {
    private final List<Integer> ballInputList;

    public BallInfo(List<Integer> ballInputList) {
        this.ballInputList = ballInputList;
    }

    public List<Integer> getBallInputList(){
        return ballInputList;
    }
}
