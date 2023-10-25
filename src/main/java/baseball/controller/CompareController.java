package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class CompareController {
    private int strike;
    private int ball;

    public int [] gameResult(List<Integer> userNumber, List<Integer> computerNumber){
        resetCnt();
        strikeCompare(userNumber,computerNumber);
        ballCompare(userNumber, computerNumber);
        exceptBall();
        return new int[]{ball,strike};
    }

    public void resetCnt(){
        strike=0;
        ball=0;
    }
    public void strikeCompare(List<Integer> userNumber, List<Integer> computerNumber){
        for(int i = 0; i<userNumber.size(); i++){
            if(computerNumber.get(i) == userNumber.get(i)){
                strike++;
            }
        }
    }
    public void ballCompare(List<Integer> userNumber, List<Integer> computerNumber){
        for(int i=0; i<userNumber.size(); i++){
            if(computerNumber.contains(userNumber.get(i))){
                ball++;
            }
        }
    }

    public void exceptBall(){
        ball-=strike;
    }

}
