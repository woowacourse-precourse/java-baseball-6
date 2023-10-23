package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

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
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}
