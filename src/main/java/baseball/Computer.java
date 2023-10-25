package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public int cntStrike = 0;
    public int cntBall = 0;

    public List<Integer> computer;

    public List<Integer> selectNumbers() {
        computer = new ArrayList<>();
        while (computer.size() < Game.INPUT_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Game.START_NUMBER, Game.LAST_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;

    }

    public void compare(String input) {
        cntStrike = 0;
        cntBall = 0;

        for (int i = 0; i < computer.size(); i++) {
            int num = Player.inputStrParseInt(input, i);
            if ((num) == computer.get(i)) {
                cntStrike += 1;
            } else if (computer.contains(num)) {
                cntBall += 1;
            }

        }
    }
    public void countResult() {
        if (cntStrike == 0 && cntBall == 0) {
            System.out.println("낫싱");
        } else if (cntStrike == 0 && cntBall > 0 ) {
            System.out.println(cntBall + "볼");
        } else if (cntStrike > 0 && cntBall > 0) {
            System.out.println(cntBall + "볼 "+ cntStrike + "스트라이크");
        } else if (cntStrike > 0 && cntBall == 0 ) {
            System.out.println(cntStrike + "스트라이크");
            if (cntStrike ==Game.INPUT_NUMBER_LENGTH) {
                System.out.println(Game.INPUT_NUMBER_LENGTH+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }

    }

    public void gameResult() {
        if (cntStrike == Game.INPUT_NUMBER_LENGTH && cntBall == 0) {
            Game.restartOrNot();
        } else {
            Game.startGame();
        }
    }
}