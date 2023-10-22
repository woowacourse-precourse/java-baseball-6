package baseball.view;

import baseball.domain.GameResult;

public class OutputView {

    public static void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printResult(GameResult gameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        if (gameResult.getBall() != 0) {
            stringBuilder.append(gameResult.getBall()).append("볼");
        }
        if (gameResult.getStrike() != 0) {
            if(!stringBuilder.isEmpty()) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(gameResult.getStrike()).append("스트라이크");
        }
        if (stringBuilder.isEmpty()) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(stringBuilder);
    }

}
