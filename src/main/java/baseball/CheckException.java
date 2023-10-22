package baseball;

import java.util.*;
import java.util.stream.Collectors;

public class CheckException {

    public static List<Integer> giveException(String tempBall) {

        List<Integer> integerTempBall;

        /** 다른 문자 입력할 때 **/
        try {
            integerTempBall = Arrays.stream(tempBall.split(""))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        /** 숫자가 3개가 아닐 때 **/
        if (integerTempBall.size() != 3) {
            throw new IllegalArgumentException();
        }

        /** 0 입력할 때 **/
        if (integerTempBall.contains(0)) {
            throw new IllegalArgumentException();
        }

        /** 같은 숫자 입력할 때 **/
        Set<Integer> tempSet = new HashSet<>(integerTempBall);
        if(tempSet.size() != 3) {
            throw new IllegalArgumentException();
        }

        return integerTempBall;
    }
}
