package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class GameModel {
    private static final int NUMBER_SIZE = 3;
    private List<Integer> computer;

    public void generateComputerNumbers() {
        computer.clear();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public GameModel() {
        this.computer = new ArrayList<>();
    }

    public int calculateStrikes(List<Integer> answer) {
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int calculateBalls(List<Integer> answer) {
        int ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (!answer.get(i).equals(computer.get(i)) && computer.contains(answer.get(i))) {
                ball++;
            }
        }
        return ball;
    }
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String END_MESSAGE = "게임 종료";
    public static final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String ASK_NUMBERS = "숫자를 입력해주세요 : ";

}
