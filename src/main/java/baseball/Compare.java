package baseball;

import java.util.List;

public class Compare {
    public void countStirkeOrBall(List<Integer> com, List<Integer> user) {
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < com.size(); i++) {
            int userNum = user.get(i);
            if (com.get(i) == userNum) {
                strike++;
            }
            else if (com.contains(userNum)) {
                ball++;
            }
        }
        System.out.println(ball + " ," + strike);
    }
}
