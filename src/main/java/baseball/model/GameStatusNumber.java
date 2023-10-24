package baseball.model;

import java.util.List;

public class GameStatusNumber {
    public int countStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strike = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int ball = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.contains(computerNumbers.get(i)) && !userNumbers.get(i).equals(computerNumbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }
    public int countNothing(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for (int userNumber : userNumbers) {
            if (computerNumbers.contains(userNumber)) {
                return 0; // 일치하는 숫자가 하나라도 있으면 낫싱이 아님
            }
        }
        return userNumbers.size(); // 일치하는 숫자가 하나도 없으면 낫싱
    }
}
