package baseball.utils;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private RandomUtil() {}

    public static ArrayList<Integer> getRandomNumber(int digits, int start, int end){
        if (digits > (end - start + 1)) {
            throw new IllegalArgumentException("주어진 자릿수를 초과한 범위일 시 예외처리");
        }

        ArrayList<Integer> computerNumbers = new ArrayList<>();
        do{
            int randomNum = Randoms.pickNumberInRange(start, end);

            if(!computerNumbers.contains(randomNum)){
                computerNumbers.add(randomNum);
            }
        }while(computerNumbers.size() < digits);

        return computerNumbers;
    }
}
