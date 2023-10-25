package baseball;

import java.util.ArrayList;

public class Hint {
    int strike=0;
    int ball=0;
    public void strikeAndBall(ArrayList computerNumber, ArrayList userNumber, int i){
        if(userNumber.contains(computerNumber.get(i))){
            ball +=1;
        }
    }
    public void strikeScore(ArrayList computerNumber, ArrayList userNumber, int i){
        if(computerNumber.get(i).equals(userNumber.get(i))){
            strike +=1;
        }
    }
    public void ballScore(){
        ball = ball-strike;
    }
    public void allScore(ArrayList computerNumber, ArrayList userNumber){
        Message hint = new Message();
        for (int i=0; i<3; i++){
            strikeAndBall(computerNumber, userNumber, i);
            strikeScore(computerNumber, userNumber, i);
        }
        ballScore();
        hint.hintMessage(strike, ball);
    }
}
