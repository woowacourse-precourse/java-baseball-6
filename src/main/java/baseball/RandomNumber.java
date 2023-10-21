package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Hashtable;

public class RandomNumber {
    private final int digitCount;
    private Hashtable<Integer, Integer> threeRandomNumberTable;
    public RandomNumber(int digitCount){
        this.digitCount = digitCount;
    }
    public void generateRandomNumber(){
        this.threeRandomNumberTable = new Hashtable<Integer, Integer>();
        int sequenceNumber = 0;

        while (sequenceNumber != this.digitCount){
            int randomDigit = pickNumberInRange(1, 9);
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
