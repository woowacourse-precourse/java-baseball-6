package baseball;

import java.util.List;

public class PlayerBalls implements Balls {
    List<Integer> ballsList;
    @Override
    public void createBalls(){
        ballsList = new ValidInputBallsList().createInputBallsList();
    }
    public List<Integer> getBallsList() {
        return ballsList;
    }
}
