package baseball;

import java.util.List;

public class CompareNum {

    public int countTotal(List<Integer> computerNum, List<Integer> userNum) {
        int total = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if(computerNum.contains(userNum.get(i))) {
                total++;
            }
        }

        // ball = total - strike
        return total;
    }

    public int countStrikes(List<Integer> computerNum, List<Integer> userNum) {
        int strike = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if(userNum.get(i).equals(computerNum.get(i))) {
                strike++;
            }
        }
        return strike;
    }
}
