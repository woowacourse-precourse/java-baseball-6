package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Hashtable;

public class RandomNumber {
    private Hashtable<Integer, Integer> threeRandomNumberTable;

    private static final int MIN_RANDOM_NUMBER = BaseballController.MIN_INPUT_CHARACTER - '0';
    private static final int MAX_RANDOM_NUMBER = BaseballController.MAX_INPUT_CHARACTER - '0';
    public RandomNumber(){

    }
    public void generateRandomNumber(){
        this.threeRandomNumberTable = new Hashtable<>();
        int sequenceNumber = 0;

        while (sequenceNumber != BaseballController.NUMBER_OF_DIGITS){
            int randomDigit = pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!threeRandomNumberTable.containsKey(randomDigit)){
                threeRandomNumberTable.put(randomDigit, sequenceNumber);
                sequenceNumber++;
                System.out.print(randomDigit);
            }
        }
        System.out.println();
    }

    public PitchingResult checkPitchingResult(int pitchingNumber, int pitchingSequence){
        if (this.threeRandomNumberTable.containsKey(pitchingNumber)){
            if (this.threeRandomNumberTable.get(pitchingNumber) == pitchingSequence){
                return PitchingResult.STRIKE;
            }
            return PitchingResult.BALL;
        }
        return PitchingResult.NOTHING;
    }
}
