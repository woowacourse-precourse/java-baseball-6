package baseball.domain;

import baseball.domain.dto.Score;

import java.util.List;

import static baseball.Application.NUM_DIGITS;

public final class Referee {

    private Referee() {
    }

    public static Score makeScore(List<Integer> userNumber, List<Integer> computerNumber){
        return new Score(
                makeBallCount(userNumber,computerNumber),
                makeStrikeCount(userNumber, computerNumber)
        );
    }

    private static int makeBallCount(List<Integer> userNumber, List<Integer> computerNumber){
        int numBalls=0;
        for(int i=0;i<NUM_DIGITS;i++){
            if(userNumber.get(i)!=computerNumber.get(i) && computerNumber.contains(userNumber.get(i))){
                numBalls++;
            }
        }
        return numBalls;
    }

    private static int makeStrikeCount(List<Integer> userNumber, List<Integer> computerNumber){
        int numStrikes=0;
        for(int i=0;i<NUM_DIGITS;i++){
            if(userNumber.get(i)==computerNumber.get(i)){
                numStrikes++;
            }
        }
        return numStrikes;
    }

}
