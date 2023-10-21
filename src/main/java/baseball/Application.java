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
    void play() {
        makeComNum();
        System.out.println(computer);
    }
    private void makeComNum() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    private int countStrike(List<Integer> user) {
        int strike = 0;
        for (int i=0; i<3; i++) {
            if (user.get(i) == computer.get(i)) {
                strike++;
            }
        }
        return strike;
    }
    // countBall
    // printResult
}