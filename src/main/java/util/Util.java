package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Integer> toIntegerArray(String input) {
        final List<Integer> inputList = new ArrayList<>();
        for (String s : input.split("")) {
            inputList.add(Integer.valueOf(s));
        }
        return inputList;
    }

    public static List<Integer> makeRandomNumbers() {
        final List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}