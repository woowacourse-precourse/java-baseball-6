package computer;

import baseball.Balls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comparator {


    private static final int BALLS_SIZE=3;
    private static final int STRIKE=0;
    private static final int BALL=1;
    private List<Integer> computerNumber=new ArrayList<>();
    private List<Integer> userNumber=new ArrayList<>();
    List<Integer> hint=new ArrayList<>(Arrays.asList(0,0));
    private int strike;
    private int ball;

    public void compare(Balls computer, Balls user){
        receiveBalls(computer,user);
        initScore();
        int current=0;
        while(current<BALLS_SIZE){
            if(computerNumber.get(current).equals(userNumber.get(current))){
                strike++;
                current++;
                continue;
            }
            if(computerNumber.contains(userNumber.get(current))){
                ball++;
                current++;
            }
        }
    }

    private void receiveBalls(Balls computer,Balls user){

        computer.getBalls().stream().forEach(n->this.computerNumber.add(n));
        //this.userNumber=user.getBalls();
        user.getBalls().stream().forEach(n->this.userNumber.add(n));
    }

    private void initScore(){
        strike=0;
        ball=0;
    }

    public List<Integer> getHint(){
        hint.set(STRIKE,strike);
        hint.set(BALL,ball);
        return hint;
    }
}
