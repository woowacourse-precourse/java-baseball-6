package baseball;

import java.util.List;

public class Message {
    public String start() {
        return "숫자 야구 게임을 시작합니다.";
    }

    public String requestInput() {
        return "숫자를 입력해주세요 : ";
    }

    public String success() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public String requestRetryOrEnd() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }

    public String result(List<Integer> gameResult) {
        if (gameResult == null) {
            return "낫싱";
        }
        final int ball = gameResult.get(0);
        final int strike = gameResult.get(1);
        if (ball > 0 && strike == 0) {
            return ball + "볼";
        }
        if (ball == 0 && strike > 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
