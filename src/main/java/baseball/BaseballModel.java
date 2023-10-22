package baseball;

import java.util.Iterator;

public class BaseballModel {

    private RandomNumber randomNumber;
    private RoundResult roundResult;
    public BaseballModel(){
        this.randomNumber = new RandomNumber();
        this.randomNumber.generateRandomNumber();

        this.roundResult = new RoundResult();
    }

    public void restart(){
        this.randomNumber.generateRandomNumber();
    }


    public RoundResult getRoundResult(Iterator<Integer> playerGuessIterator) {
        this.roundResult.resetCount();
        int pitchingSequence = 0;
        while (playerGuessIterator.hasNext()){
            PitchingResult pitchingResult = this.randomNumber.checkPitchingResult(playerGuessIterator.next(), pitchingSequence++);
            if (pitchingResult == PitchingResult.STRIKE){
                this.roundResult.addStrikeCount();
            }
            if (pitchingResult == PitchingResult.BALL){
                this.roundResult.addBallCount();
            }
        }
        return this.roundResult;
    }
}
