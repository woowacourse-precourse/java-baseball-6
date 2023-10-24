package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class ComputerRandomNumber {
    public static int pickNumber(){
        int result = Randoms.pickNumberInRange(1,9);
        return result;
    }

    public static Set<Integer> pickNumberSet() {
        Set<Integer> pickNumberSet = new HashSet<>();

        while (pickNumberSet.size() < 3) {
            pickNumberSet.add(pickNumber());
        }

        return pickNumberSet;
    }

    public static String setToString(Set<Integer>  set) {
        StringBuilder builder = new StringBuilder();
        for (int item : set) {
            builder.append(item);
        }
        return builder.toString();
    }


    public static String pickNumberSetToString(){
        return setToString(pickNumberSet());
    }

    public static String computerRandomNumber(){
        return pickNumberSetToString();
    }
}
