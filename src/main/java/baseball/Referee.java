package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    private List<BallCount> ballCounts = new ArrayList<>();
    private String call;

    public Referee (){
        this.call = "";
    }

    public String getCall(){
        return this.call;
    }

    public void judgement(List<Integer> answerNumbers, List<Integer> guessNumbers){
        ballCounts.clear();
        for (int i=0; i<3; i++){
            int guessNumber = guessNumbers.get(i);

            if (guessNumber == answerNumbers.get(i)){
                this.ballCounts.add(BallCount.STRIKE);
            }
            else if (answerNumbers.contains(guessNumber)) {
                this.ballCounts.add(BallCount.BALL);
            }
        }
    }
    public void call() {

        this.call = "";

        int strike = Collections.frequency(ballCounts, BallCount.STRIKE);
        int ball = Collections.frequency(ballCounts, BallCount.BALL);

        if (strike == 0 && ball == 0) {
            this.call = "낫싱";
            System.out.println(call);
            return;
        }
        System.out.println(strike + ball);
        if (ball > 0) {
            this.call += ball + BallCount.BALL.getCallName() + " ";
        }
        if (strike > 0) {
            this.call += strike + BallCount.STRIKE.getCallName();
        }

        System.out.println(this.call.trim());
    }
}
