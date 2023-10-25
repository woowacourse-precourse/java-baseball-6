package baseball.utils;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private RandomUtil() {}

    public static ArrayList<Integer> getRandomNumber(int digits, int start, int end){
        ArrayList<Integer> NUMBER_LIST = new ArrayList<>();
        do{
            int randomNum = Randoms.pickNumberInRange(start, end);

            if(!NUMBER_LIST.contains(randomNum)){
                NUMBER_LIST.add(randomNum);
            }
        }while(NUMBER_LIST.size() < digits);

        return NUMBER_LIST;
    }
}
