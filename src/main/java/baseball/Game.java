package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int COMPUTER_NUMBERS_SIZE = 3;
    private static final int RANDOM_NUMBER_MIN = 1;
    private static final int RANDOM_NUMBER_MAX = 3;

    public void run() {
        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Numbers computerNumbers = new Numbers(createComputerNumbers());
            Score score = new Score();
            while (score.isUserLose()) {
                System.out.print("숫자를 입력해주세요 : ");
                Numbers userNumbers = new Numbers(new GameInput().convertInputToUserNumbers());
                score = computerNumbers.calculateScore(userNumbers);
                System.out.println(score.getHint());
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (new EndInput().isPressResume());
    }

    private List<Integer> createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < COMPUTER_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}
