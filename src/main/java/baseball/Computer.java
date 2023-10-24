package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNum = new ArrayList<>();

    void setAnswerNum() {
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
    }

    boolean checkNum(String userNum) {
        int strike = 0;
        int ball = 0;

        if (userNum == null) {
            return (false);
        }
        for (int i = 0; i < 3; i++) {
            if (computerNum.get(i).equals(Integer.parseInt(String.valueOf(userNum.charAt(i))))) {
                ++strike;
            } else if (computerNum.contains(Integer.parseInt(String.valueOf(userNum.charAt(i))))) {
                ++ball;
            }
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball >= 1 && strike >= 1) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball >= 1) {
            System.out.println(ball + "볼");
        } else if (strike >= 1) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 3) {
            return (true);
        }
        return (false);
    }
}
