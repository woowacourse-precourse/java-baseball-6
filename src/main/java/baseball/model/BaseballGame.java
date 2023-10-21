package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGame {
    private final List<Integer> computer;
    private final List<Integer> user;
    private BaseballGameCounts baseballGameCounts;

    protected BaseballGame() {
        this.computer = new ArrayList<>();
        this.user = new ArrayList<>();
        this.baseballGameCounts = BaseballGameCounts.createBaseballGameCounts();
    }

    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public void run() {
        // 랜덤 수 생성
        this.generateRandomNum();

        while (true) {
            this.getUserInput();

            this.checkStrikes();

            this.checkBalls();

            this.showCounts();

            if (this.baseballGameCounts.isWinCondition()) {
                return;
            }
        }
    }

    private void getUserInput() {
        String userInput = readLine();
        for (int i = 0; i < userInput.length(); i++) {
            user.add(Character.getNumericValue(userInput.charAt(i)));
        }
    }

    private void showCounts() {
    }

    private void checkBalls() {

    }

    private void checkStrikes() {

    }

    private void generateRandomNum() {
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}