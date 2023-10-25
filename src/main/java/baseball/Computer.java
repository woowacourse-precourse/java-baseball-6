package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Computer {

    private Map<Integer, Integer> numberMap;

    public Computer() { this.numberMap = new HashMap<>(); }

    public Map<Integer, Integer> makeComputerRandomNum() {
        final int START = 1;
        final int END = 9;
        final int DIGIT = 3;

        if ( this.numberMap == null ) {
            this.numberMap = new HashMap<>();
        }

        int randomValue = 100;
        while ( numberMap.size() < DIGIT ) {
            int randomNumber = Randoms.pickNumberInRange( START, END );
            if ( !numberMap.containsKey(randomNumber) ) {
                numberMap.put( randomNumber, randomValue );
                randomValue /= 10;
            }
        }
        return numberMap;
    }
}
