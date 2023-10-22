package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameUtils {

    public BaseballGameUtils() {

    }

    public List<Integer> makeComputerNumber() {
        // 예시처럼 구현하고, 사용자 입력도 같은수를 입력받지 못하도록??
        // 예시에는 같은 수 입력 안되도록 돼있음

        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public Score checkScore(List<Integer> computerNumber, List<Integer> userNumber) {

        int ball = 0;
        int strike = 0;

        ball = checkBall(computerNumber, userNumber);
        strike = checkStrike(computerNumber, userNumber);

        return new Score(ball, strike);
    }

    public int checkBall(List<Integer> computerNumber, List<Integer> userNumber) {

        int count = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.contains(userNumber.get(i)) && computerNumber.indexOf(userNumber.get(i)) != i)
                count++;
        }

        return count;
    }

    public int checkStrike(List<Integer> computerNumber, List<Integer> userNumber) {

        int count = 0;

        for(int i = 0; i < computerNumber.size(); i++) {
            if(computerNumber.get(i) == userNumber.get(i)) {
                count++;
            }
        }

        return count;
    }

}
