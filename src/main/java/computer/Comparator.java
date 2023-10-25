package computer;

import baseball.Balls;

import java.util.ArrayList;
import java.util.List;

public class Comparator {

    private static final int BALLS_SIZE=3;
    private static final int FIRST_BALL=0;
    private static final int INIT=0;
    private Balls computer;
    private Balls user;

    public void compare(Balls computer, Balls user){

        int strike=INIT;
        int ball=INIT;
        receiveBalls(computer, user);

        for (int current = FIRST_BALL; current < BALLS_SIZE; current++) {
            if (isSameValueAtSameLocation(current)) {
                strike++;
                continue;
            }
            if(isContainInComputerNumber(current)){
                ball++;
            }
        }
        storeToHint(strike, ball);
    }

    private void receiveBalls(Balls computer,Balls user){
        this.computer=computer;
        this.user=user;
    }

    private boolean isSameValueAtSameLocation(int location){
        return computer.getBalls().get(location)
                .equals(user.getBalls().get(location));
    }

    private boolean isContainInComputerNumber(int location){
        return computer.getBalls()
                .contains(user.getBalls().get(location));

    }

    private void storeToHint(int strike,int ball){
        Hint hint = Hint.getInstance();
        hint.save(strike, ball);
    }

}
