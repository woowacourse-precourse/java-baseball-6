package service;

import java.util.List;

public class ViewService {

    public static int strike(List<Integer> randomNumber, List<Integer> userNumber) {
        int strike = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (randomNumber.get(i).equals(userNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int ball(List<Integer> randomNumber, List<Integer> userNumber) {
        int ball = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (randomNumber.contains(userNumber.get(i)) && !randomNumber.get(i).equals(userNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
