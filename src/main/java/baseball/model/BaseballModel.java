package baseball.model;

import java.util.Iterator;

public class BaseballModel {
    private RandomNumber randomNumber;
    private AttemptResult attemptResult;

    public BaseballModel(){
        this.randomNumber = new RandomNumber();
        this.attemptResult = new AttemptResult();

        this.randomNumber.generateRandomNumber();
    }

    public void restart(){
        randomNumber.generateRandomNumber();
    }

    public AttemptResult getAttemptResult(Iterator<Integer> playerGuessIterator) {
        attemptResult.reset();
        int guessNumberSequence = 0;

        while (playerGuessIterator.hasNext()){
            int playerGuessNumber = playerGuessIterator.next();
            PitchingResult pitchingResult = randomNumber.checkPitchingResult(playerGuessNumber, guessNumberSequence);
            guessNumberSequence++;

            if (pitchingResult == PitchingResult.STRIKE){
                attemptResult.incrementStrikeCount();
            }

            if (pitchingResult == PitchingResult.BALL){
                attemptResult.incrementBallCount();
            }
        }
        return attemptResult;
    }
}
