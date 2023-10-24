package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public static List<Integer> generateRandomNumber(int size) {
        List<Integer> randomNumberList = new ArrayList<>();
        while(randomNumberList.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> integerList = new ArrayList<>();
        for(String s : input.split("")) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }
}
