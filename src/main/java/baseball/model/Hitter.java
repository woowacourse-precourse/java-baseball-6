package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Hitter {
    private List<Integer> hitterNum;

    public Hitter() {
    }

    public Hitter(String hitterString) {
        hitterNum = new ArrayList<>();

        for (int i = 0; i < hitterString.length(); i++) {
            char digitChar = hitterString.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            hitterNum.add(digit);
        }
    }

    public List<Integer> getHitterNum() {
        return hitterNum;
    }
}