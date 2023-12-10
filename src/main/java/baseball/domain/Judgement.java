package baseball.domain;

import java.util.List;

public class Judgement {

    public int correctCounts(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (Integer number : player) {
            if (computer.contains(number)) {
                result++;
            }
        }
        return result;
    }

    public boolean hasPlace(List<Integer> computer, int positon, int number) {
        return computer.get(positon) == number;
    }


}


