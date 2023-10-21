package computer;

import baseball.Balls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comparator {


    private static final int BALLS_SIZE=3;
    private static final int STRIKE=0;
    private static final int BALL=1;
    public List<Integer> computerNumber=new ArrayList<>();
    public List<Integer> userNumber=new ArrayList<>();
    public int strike;
    public int ball;

    public void compare(Balls computer, Balls user){

        initScore();
        initNumber();
        receiveBalls(computer,user);
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
                continue;
            }
            current++;
        }
        store(strike,ball);
    }

    private void receiveBalls(Balls computer,Balls user){

        //this.computerNumber=computer.getBalls();
        computer.getBalls().stream().forEach(n->this.computerNumber.add(n));
        //this.userNumber=user.getBalls();
        user.getBalls().stream().forEach(n->this.userNumber.add(n));
    }

    private void initScore(){
        strike=0;
        ball=0;
    }

    private void initNumber(){
        computerNumber.clear();
        userNumber.clear();
    }

    public void store(int strike,int ball){
        Hint hint=new Hint();
        hint.save(strike,ball);
    }


}
