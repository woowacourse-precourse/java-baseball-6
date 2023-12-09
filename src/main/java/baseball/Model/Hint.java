package baseball.Model;

import static baseball.Constants.*;
import static baseball.Controller.Array.*;
import static baseball.View.OutputView.*;

class Hint {
    int ball, strike;

    public String toString(){
        return "ball: " + this.ball + ", strike: " + this.strike;
    }

    private void ballCount() {
        this.ball++;
    }

    private void strikeCount() {
        this.strike++;
    }

    void compareAns(Game answer, Game correctAnswer){
        for(int i = 0; i < NUM_SIZE; i++){
            int currentNumber = answer.compareNumList.get(i);

            if(!checkArrayContains(correctAnswer.compareNumList, currentNumber)){
                continue;
            }
            if(i == getIndexFromValue(correctAnswer.compareNumList, currentNumber)){
                strikeCount();
                continue;
            }
            ballCount();
        }
    }
    void setCount(){
        String result = "";
        if(this.ball != NO_COUNT){
            result += this.ball + BALL;
        }
        if(this.strike != NO_COUNT){
            if(this.ball != NO_COUNT){
                result += " ";
            }
            result += this.strike + STRIKE;
        }
        if(result.isEmpty()){
            result = NOTHING;
        }
        printResult(result);
    }
}
