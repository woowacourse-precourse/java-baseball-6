package Model;

import java.util.ArrayList;

public class Refree {
    public boolean isStrike(int CurrentNumber, ArrayList<Integer> Numbers, int digit) {
        if (Numbers.get(digit) == CurrentNumber) {
            return true;
        }
        return false;
    }

    public boolean isBall(int CurrentNumber, ArrayList<Integer> Numbers, int digit) {
        for (int i = 0; i < Numbers.size(); i++) {
            if (CurrentNumber == Numbers.get(i)) {
                if (i != digit) {
                    return true;
                }
            }
        }
        return false;
    }
}
