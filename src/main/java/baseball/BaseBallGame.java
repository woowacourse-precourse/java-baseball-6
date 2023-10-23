package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private boolean end;
    private int strike, ball;
    private List<Integer> computer = new ArrayList<>();

    private void init() {
        end = false;
        computer = new ArrayList<>();
        getRandomNumber();
    }

    private void getRandomNumber() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private void compare(List<Integer> num) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(i).equals(num.get(j))) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
    }

    private void play() {
        do {
            List<Integer> num = Util.getNumber();
            compare(num);

            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike > 0 && ball > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (ball > 0) {
                System.out.println(ball + "볼");
            } else {
                if (strike == 3) {
                    end = true;
                }
                System.out.println(strike + "스트라이크");
            }
        } while (!end);
    }

    public void start() {
        init();
        play();
        end();
    }

    public void end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
