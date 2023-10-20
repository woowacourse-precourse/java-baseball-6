package baseball;

import java.util.List;

public class RandomBalls implements Balls {
    private List<Integer> ballsList;
    @Override
    public void createBalls(){
        ballsList = new ValidRandomBallsList().createValidRandomBallsList();
    }
    public List<Integer> getBallsList() {
        return ballsList;
    }
}
