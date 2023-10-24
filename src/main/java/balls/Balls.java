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
}
