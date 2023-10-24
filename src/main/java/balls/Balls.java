package balls;

import utils.Utils;

import java.util.List;

public class Balls {
    List<Integer> balls;
    Utils utils= new Utils();
    public Balls(List<Integer> balls){
        this.balls = balls;
    }
    public Balls(String input){
        utils.userGameStartValidation(input);
        this.balls= utils.stringToIntList(input);
    }
    public int getBallsSize(){
        return balls.size();
    }
    public int getBalls(int index){
        return balls.get(index);
    }
    public boolean compareToByBall(Balls anotherBalls, int digit){
        for(int index=0; index< getBallsSize(); index++){
            if(digit==index){
                continue;
            }
            if(anotherBalls.getBalls(index)==getBalls(digit)){
                return true;
            }
        }
        return false;
    }
    public boolean compareToByStrike(Balls anotherBalls, int digit){
        if(anotherBalls.getBalls(digit)==getBalls(digit)){
            return true;
        }
        return false;
    }

}
