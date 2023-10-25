package baseball.domain.computer;

import baseball.domain.game.Input;
import java.util.List;
import java.util.Objects;

public class Computer {
    private int ballCount;
    private int strikeCount;

    // 사용자가 정답을 입력하면 참을 반환
    public boolean isAnswer(List<Integer> userInputs, List<Integer> randomNumbers) {
        // 정답 비교
        countBallAndStrike(userInputs, randomNumbers);
        // 3스트라이크라면 true, 아니라면 false
        if (this.strikeCount == Input.NUMLENGTH.getLength()) {
            return true;
        }
        return false;
    }

    // 볼, 스트라이크 여부를 판별
    public void countBallAndStrike(List<Integer> userInputs, List<Integer> randomNumbers) {
        // ballCount, strikeCount 초기화
        this.clear();

        // 각 사용자 입력수에 대해
        for (int i = 0; i < userInputs.size(); i++) {
            // 랜덤수 리슽트가 사용자 입력수를 가지고 있다면
            if (randomNumbers.contains(userInputs.get(i))) {
                // 위치가 같다면 스트라이크
                if (Objects.equals(userInputs.get(i), randomNumbers.get(i))) {
                    this.strikeCount += 1;
                    continue;
                }
                this.ballCount += 1;
            }
        }
    }

    // 볼,스트라이크 상태 문자열 반환
    public String showResult() {
        if (ballCount > 0 && strikeCount > 0) {
            // return 볼 && 스트라이크
            return String.format("%s볼 %s스트라이크", ballCount, strikeCount);
        }
        if (strikeCount > 0) {
            // return 스트라이크
            return String.format("%s스트라이크", strikeCount);
        }
        if (ballCount > 0) {
            // return 볼
            return String.format("%s볼", ballCount);
        } else {
            return "낫싱";
        }
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    // 상태 초기화
    public void clear() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

}
