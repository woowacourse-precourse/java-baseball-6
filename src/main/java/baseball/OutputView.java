package baseball;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(GameResult result) {
        int ballCount = result.ballCount();
        int strikeCount = result.strikeCount();

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }

        List<String> parts = new ArrayList<>();

        if (ballCount > 0) {
            parts.add(ballCount + "볼");
        }

        if (strikeCount > 0) {
            parts.add(strikeCount + "스트라이크");
        }

        System.out.println(String.join(" ", parts));
    }

    public void printCorrectAnswerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
