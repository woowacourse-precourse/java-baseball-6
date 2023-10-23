package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import jdk.jshell.execution.Util;

import java.util.Arrays;

public class Computer {
    private int[] numbers = new int[3];

    public void generateNumber(){
        do {
            numbers = pickNumbers();
        } while (Util.isDuplicated(numbers));

    }

    public int[] pickNumbers(){
        return Arrays.stream(new int[3])
                .map(num -> Randoms.pickNumberInRange(1, 9))
                .toArray();
    }
}
