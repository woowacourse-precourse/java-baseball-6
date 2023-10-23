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
        randomNumber.generateRandomNumber();
    }

    public AttemptResult getAttemptResult(Iterator<Integer> playerGuessIterator) {
        attemptResult.reset();
        int pitchingSequence = 0;
        while (playerGuessIterator.hasNext()){
            PitchingResult pitchingResult = randomNumber.checkPitchingResult(playerGuessIterator.next(), pitchingSequence++);
            if (pitchingResult == PitchingResult.STRIKE){
                attemptResult.addStrikeCount();
            }
            if (pitchingResult == PitchingResult.BALL){
                attemptResult.addBallCount();
            }
        }
        return attemptResult;
    }
}
