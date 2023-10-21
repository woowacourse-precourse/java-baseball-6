package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int NUM_OF_DIGITS = 3;

    public void start() {
        // 사용자가 2를 입력하면 종료 or 1을 입력하면 게임 지속
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            int randomNumber = generateRandomNumber();

        }
    }

    private int generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int randomNumber = 0;
        for (int i = 0; i < computer.size(); i++) {
            randomNumber += (computer.get(i) * (int) Math.pow(10, computer.size() - i - 1));
        }
        return randomNumber;
    }

}
