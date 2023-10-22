package computer;

import baseball.Balls;

import java.util.ArrayList;
import java.util.List;

public class Comparator {

    private static final int BALLS_SIZE=3;
    private List<Integer> computerNumber=new ArrayList<>();
    private List<Integer> userNumber=new ArrayList<>();
    private int strike;
    private int ball;

    public void compare(Balls computer, Balls user){

        initScore();
        initNumber();
        receiveBalls(computer, user);

        for(int current=0; current<3;current++) {
            if(isSameValueAtSameLocation(current)){
                continue;
            }
            isContainInComputerNumber(current);

        }
        storeToHint(strike, ball);
    }

    private boolean isSameValueAtSameLocation(int location){
        if (computerNumber.get(location).equals(userNumber.get(location))) {
            strike++;
            return true;
        }
        return false;
    }

    private boolean isContainInComputerNumber(int location){
        if (computerNumber.contains(userNumber.get(location))) {
            ball++;
            return true;
        }
        return false;
    }

    private void receiveBalls(Balls computer,Balls user){

        computer.getBalls().stream().forEach(n -> this.computerNumber.add(n));
        //this.userNumber=user.getBalls();
        user.getBalls().stream().forEach(n -> this.userNumber.add(n));
    }

    private void initScore(){
        strike=0;
        ball=0;
    }

    private void initNumber(){
        computerNumber.clear();
        userNumber.clear();
    }

    public void storeToHint(int strike,int ball){
        Hint hint = new Hint();
        hint.save(strike, ball);
    }

}
