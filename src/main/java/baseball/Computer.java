package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Computer {
    private static final int INPUT_NUMBER_LENGTH = 3;
    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 9;
    private static Player player;
    private static Game game;

    public int cntStrike = 0;
    public int cntBall = 0;

    public List<Integer> computer;

    public List<Integer> selectNumbers() {
        computer = new ArrayList<>();
        while (computer.size() < INPUT_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, LAST_NUMBER);
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
            int num = player.inputStrParseInt(input, i);
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
            if (cntStrike ==INPUT_NUMBER_LENGTH) {
                System.out.println(INPUT_NUMBER_LENGTH+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }

    }

    public void gameResult() {
        if (cntStrike == INPUT_NUMBER_LENGTH && cntBall == 0) {
            game.restartOrNot();
        } else {
            game.startGame();
        }
    }
}