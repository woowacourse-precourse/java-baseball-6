package baseball;

import java.util.Iterator;

public class BaseballModel {
    private RandomNumber randomNumber;
    private AttemptResult attemptResult;
    public BaseballModel(){
        this.randomNumber = new RandomNumber();
        this.randomNumber.generateRandomNumber();

        this.attemptResult = new AttemptResult();
    }

    public void restart(){
        this.randomNumber.generateRandomNumber();
    }

    public AttemptResult getAttemptResult(Iterator<Integer> playerGuessIterator) {
        this.attemptResult.reset();
        int pitchingSequence = 0;
        while (playerGuessIterator.hasNext()){
            PitchingResult pitchingResult = this.randomNumber.checkPitchingResult(playerGuessIterator.next(), pitchingSequence++);
            if (pitchingResult == PitchingResult.STRIKE){
                this.attemptResult.addStrikeCount();
            }
            if (pitchingResult == PitchingResult.BALL){
                this.attemptResult.addBallCount();
            }
        }
        return this.attemptResult;
    }
}
