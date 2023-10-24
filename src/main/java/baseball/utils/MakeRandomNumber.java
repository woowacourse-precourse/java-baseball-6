package baseball.utils;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class MakeRandomNumber {
    /**
     * 각 자리수가 다른 난수
     */
    public static int[] getRandomNumbers(int size){
        int[] numbers = new int[size];
        boolean[] isUnique = new boolean[10];
        Arrays.fill(isUnique,true);

        for (int i = 0; i < size; i++){
            numbers[i] = getUniqueRandomNumber(numbers,i);
        }
        return numbers;
    }
    private static int getUniqueRandomNumber(int[] numbers,int i) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (!isUnique(numbers, i, randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumber;
    }
    private static boolean isUnique(int[] numbers,int i,int randomNumber){
        for (int j = 0; j < i; j++) {
            if (numbers[j] == randomNumber) {
                return false;
            }
        }
        return true;
    }

}
