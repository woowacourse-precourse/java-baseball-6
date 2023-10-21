package baseball;

import java.util.List;

public class Compare {
    public int countBall(List<Integer> computer, List<Integer> userNumber) {
        int total = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.contains(computer.get(i)))
                total++;
        }
        return total;
    }

    public int countStrike(List<Integer> computer, List<Integer> userNumber){
        int strike = 0;
        for (int i=0; i<userNumber.size(); i++) {
            if (computer.get(i) == userNumber.get(i)) {
                strike++;
            }
        }
        return strike;
    }
}