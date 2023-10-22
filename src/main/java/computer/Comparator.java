package computer;

import baseball.Balls;

import java.util.ArrayList;
import java.util.List;

public class Comparator {

    private static final int BALLS_SIZE=3;
    private Balls computer;
    private Balls user;
    private int strike;
    private int ball;

    public void compare(Balls computer, Balls user){

        initScore();
        receiveBalls(computer, user);

        for (int current = 0; current < BALLS_SIZE; current++) {
            if (isSameValueAtSameLocation(current)) {
                continue;
            }
            isContainInComputerNumber(current);

        }
        storeToHint(strike, ball);
    }

    private boolean isSameValueAtSameLocation(int location){
        if (computer.getBalls().get(location).equals(user.getBalls().get(location))) {
            strike++;
            return true;
        }
        return false;
    }

    private boolean isContainInComputerNumber(int location){
        if (computer.getBalls().contains(user.getBalls().get(location))) {
            ball++;
            return true;
        }
        return false;
    }

    private void receiveBalls(Balls computer,Balls user){
        this.computer=computer;
        this.user=user;
    }

    private void initScore(){
        strike=0;
        ball=0;
    }

    public void storeToHint(int strike,int ball){
        Hint hint = new Hint();
        hint.save(strike, ball);
    }

}
