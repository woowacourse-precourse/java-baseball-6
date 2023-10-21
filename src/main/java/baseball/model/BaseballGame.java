package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGame {
    private final List<Integer> computer = new ArrayList<>();
    private final List<Integer> user = new ArrayList<>();
    private final BaseballGameCounts baseballGameCounts = BaseballGameCounts.createBaseballGameCounts();

    protected BaseballGame() {}

    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public void run() {
        // 랜덤 수 생성
        this.generateRandomNum();

        while (true) {
            this.getUserInput();

            this.checkBalls();

            this.checkStrikes();

            this.baseballGameCounts.showCounts();

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

    private void checkBalls() {
        int counts = 0;
        for (Integer idx : user) {
            if (computer.contains(user.get(idx)) && !Objects.equals(computer.get(idx), user.get(idx))) {
                counts++;
            }
        }
        if(counts > 0)
            baseballGameCounts.editMessage(String.format("%볼 ",counts));
    }

    private void checkStrikes() {
        int counts = 0;
        for (Integer idx : user) {
            if (user.get(idx).equals(computer.get(idx))) {
                counts++;
            }
        }
        if(counts > 0)
            baseballGameCounts.editMessage(String.format("%d스트라이크",counts));
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