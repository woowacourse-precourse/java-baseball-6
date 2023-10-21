package baseball;

import java.util.List;

public class Compare {
    public int countStirke(List<Integer> com, List<Integer> user) {
        int strike = 0;
        for(int i = 0; i < com.size(); i++) {
            int userNum = user.get(i);
            if (com.get(i) == userNum) {
                strike++;
            }
        }
        return strike;
    }
    public int countAll(List<Integer> com, List<Integer> user) {
        int all = 0;
        for(int i = 0; i < com.size(); i++) {
            int userNum = user.get(i);
            if (com.contains(userNum)) {
                all++;
            }
        }
        return all;
    }
    public void compareResult(List<Integer> com, List<Integer> user) {
        int strike;
        int ball;
        strike = countStirke(com, user);
        ball = countAll(com, user) - strike;
        System.out.println(ball + ", " + strike);
    }
}
