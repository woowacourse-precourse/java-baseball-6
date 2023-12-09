package baseball;

import static baseball.Constants.*;

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
        int nowNumber;

        for(int i = 0; i < NUM_SIZE; i++){
            nowNumber = answer.num.get(i);

            if(!Array.checkArrayContains(correctAnswer.num, nowNumber)){
                continue;
            }
            if(i == Array.getIndexFromValue(correctAnswer.num, nowNumber)){
                strikeCount();
                continue;
            }
            ballCount();
        }
    }
    void printResult(){
        String result = "";
        if(this.ball != 0){
            result += this.ball + BALL;
        }
        if(this.strike != 0){
            if(this.ball != 0){
                result += " ";
            }
            result += this.strike + STRIKE;
        }
        if(result.isEmpty()){
            result = NOTHING;
        }
        System.out.println(result);
    }
}
