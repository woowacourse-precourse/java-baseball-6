package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Hint {
    int strike;
    int ball;
    Message message = new Message();
    public void initScore(){
        strike=0;
        ball=0;
    }
    public int getStrikeScore(){
        return strike;
    }
    public int getBallScore(){
        return ball;
    }
    public void plusStrike(){
        strike +=1;
    }
    public void plusBall(){
        ball+=1;
    }
    public void strikeAndBall(ArrayList computerNumber, ArrayList userNumber, int i){
        if(userNumber.contains(computerNumber.get(i))){
            plusBall();
        }
    }
    public void strikeScore(ArrayList computerNumber, ArrayList userNumber, int i){
        if(computerNumber.get(i).equals(userNumber.get(i))){
            plusStrike();
        }
    }
    public void ballScore(){
        ball = ball-strike;
    }
    public void allScore(ArrayList computerNumber, ArrayList userNumber){
        initScore();
        for (int i=0; i<3; i++){
            strikeAndBall(computerNumber, userNumber, i);
            strikeScore(computerNumber, userNumber, i);
        }
        ballScore();
    }
}
