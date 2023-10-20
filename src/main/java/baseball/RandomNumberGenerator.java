package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class RandomNumberGenerator {
    int digitCount;
    public RandomNumberGenerator(){
        this.digitCount = 3;
    }
    public String generateRandomNumber(){
        int randomNumber = 0;

        while (randomNumber < (int) Math.pow(10, this.digitCount - 1)){
            int randomDigit = pickNumberInRange(1, 9);

            if (!checkRedundancy(randomNumber, randomDigit)){
                randomNumber = (randomNumber * 10) + randomDigit;
            }
        }
        return Integer.toString(randomNumber);
    }

    private boolean checkRedundancy(int randomNumber, int randomDigit){
        while (randomNumber != 0){
            if ((randomNumber % 10) == randomDigit){
                return true;
            }
            randomNumber = randomNumber / 10;
        }
        return false;
    }
}
