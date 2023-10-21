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

    protected BaseballGame() {
    }

    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 랜덤 수 생성
        this.generateRandomNum();

        while (true) {
            this.getUserInput();

            this.checkStrikes();

            this.checkBalls();

            this.baseballGameCounts.showCounts();

            if (this.baseballGameCounts.isWinCondition()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                return;
            }

            this.baseballGameCounts.resetCounts();

            this.resetUserInput();
        }
    }

    private void getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();

        // 숫자인지 검증
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        // 3자리 수 검증 확인
        if (userInput.length() != 3) throw new IllegalArgumentException("잘못된 입력입니다.");

        // 중복 자리수 검증
        for (int i = 0; i < userInput.length(); i++) {
            int num = Character.getNumericValue(userInput.charAt(i));
            if (!user.contains(num)) {
                user.add(num);
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }

    private void resetUserInput() {
        user.clear();
    }

    private void checkBalls() {
        int counts = 0;
        for (Integer idx : user) {
            if (computer.contains(idx)) {
                counts++;
            }
        }
        counts -= this.baseballGameCounts.getStrikes();
        if (counts > 0) {
            baseballGameCounts.editMessage(String.format("%d볼 ", counts));
            baseballGameCounts.setBalls(counts);
        }
    }

    private void checkStrikes() {
        int counts = 0;
        for (int idx = 0; idx < user.size(); idx++) {
            if (user.get(idx).equals(computer.get(idx))) {
                counts++;
            }
        }
        if (counts > 0) {
            baseballGameCounts.editMessage(String.format("%d스트라이크", counts));
            baseballGameCounts.setStrikes(counts);
        }
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