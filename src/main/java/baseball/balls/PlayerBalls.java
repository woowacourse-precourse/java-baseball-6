package baseball.balls;

import baseball.validation.ValidInputBallsList;

import java.util.List;

public class PlayerBalls implements Balls {
    List<Integer> ballsList;
    @Override
    public void createBalls(){
        try{
            ballsList = new ValidInputBallsList().createInputBallsList();
        }
        catch(IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        }

    }
    public List<Integer> getBallsList() {
        return ballsList;
    }
}
