package baseball.controller.output;

import baseball.domain.result.Result;

public class Output {
    private Output() {
    }

    private static class OutputHelper {
        private static final Output INSTANCE = new Output();
    }

    public static void showStart() {
        Output.OutputHelper.INSTANCE.print("숫자 야구 게임을 시작합니다.");
    }

    public static void showInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void showResult(Result result) {
        int strike = result.strike();
        int ball = result.ball();

        String msg;

        if (strike == 0 && ball == 0) {
            msg = "낫싱";
        } else if (strike == 0) {
            msg = ball + "볼";
        } else if (ball == 0) {
            msg = strike + "스트라이크";
        } else {
            msg = ball + "볼 " + strike + "스트라이크";
        }

        Output.OutputHelper.INSTANCE.print(msg);
    }

    public static void showEndMessage() {
        Output.OutputHelper.INSTANCE.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        Output.OutputHelper.INSTANCE.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void print(String msg) {
        System.out.println(msg);
    }
}
