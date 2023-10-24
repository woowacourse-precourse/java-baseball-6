package baseball;

import java.util.Map;

public class Output {
    private static final int NO_SCORE = 0;

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void hint(Map<String, Integer> result) {
        if (isNothing(result)) {
            System.out.print("낫싱");
        }
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (!isNothing(result)) {
                System.out.print(entry.getValue() + entry.getKey() + " ");
            }
        }
        System.out.println();
    }

    private boolean isNothing(Map<String, Integer> result) {
        return result.get(KeyType.STRIKE.getKey()) == NO_SCORE
                && result.get(KeyType.BALL.getKey()) == NO_SCORE;
    }

    public void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}