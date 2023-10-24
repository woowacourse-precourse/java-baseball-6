package baseball;

import java.util.Map;

public class Output {
    private static final int ZERO = 0;

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void hint(Map<String, Integer> result) {
        if (result.get(KeyType.STRIKE.getKey()) == ZERO && result.get(KeyType.BALL.getKey()) == ZERO) {
            System.out.print("낫싱");
        }
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() != ZERO) {
                System.out.print(entry.getValue() + entry.getKey() + " ");
            }
        }
        System.out.println();
    }

    public void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}