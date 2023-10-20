package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {
    public static final int MIX_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    static List<Integer> randomNumbers;
    public Computer(){
        setRandomNumbers();
    }
    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public static List<Integer> setRandomNumbers(){
        randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(MIX_NUMBER, MAX_NUMBER);
            if(!randomNumbers.contains(randomNumber))
                randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}
