package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame game = new BaseballGame();
        game.play();
    }
}

class BaseballGame {
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = new ArrayList<>();
    void play() {
        makeComNum();
        getUserNum();
    }
    private void makeComNum() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    private void getUserNum() {
        String userNumber = Console.readLine();
        for (int i=0; i<3; i++) {
            user.add(Character.getNumericValue(userNumber.charAt(i)));
        }
    }
    private int countStrike() {
        int strike = 0;
        for (int i=0; i<3; i++) {
            if (user.get(i) == computer.get(i)) {
                strike++;
            }
        }
        return strike;
    }
    private int countBall() {
        int ball = 0;
        for (int computerNum : computer) {
            if (user.contains(computerNum)) {
                ball++;
            }
        }
        return ball;
    }
    // printResult
}