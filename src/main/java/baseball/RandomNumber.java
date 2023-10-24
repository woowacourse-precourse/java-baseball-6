package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Hashtable;

public class RandomNumber {
    private Hashtable<Integer, Integer> RandomNumberTable;

    public RandomNumber(){}

    public void generateRandomNumber(){
        RandomNumberTable = new Hashtable<>();
        int sequenceNumber = 0;

        while (sequenceNumber != GameSettings.NUM_DIGITS){
            int randomDigit = pickNumberInRange(GameSettings.MIN_RANDOM_NUMBER, GameSettings.MAX_RANDOM_NUMBER);

            if (!isDuplicated(randomDigit)){
                RandomNumberTable.put(randomDigit, sequenceNumber);
                sequenceNumber++;
            }
        }
    }

    private boolean isDuplicated(int randomDigit){
        return RandomNumberTable.containsKey(randomDigit);
    }

    public PitchingResult checkPitchingResult(int pitchingNumber, int pitchingSequenceNumber){
        if (isBall(pitchingNumber)){
            if (isStrike(pitchingNumber, pitchingSequenceNumber)){
                return PitchingResult.STRIKE;
            }
            return PitchingResult.BALL;
        }
        return PitchingResult.NOTHING;
    }

    private boolean isBall(int pitchingNumber){
        return RandomNumberTable.containsKey(pitchingNumber);
    }

    private boolean isStrike(int pitchingNumber, int pitchingSequenceNumber){
        return RandomNumberTable.get(pitchingNumber) == pitchingSequenceNumber;
    }
}
