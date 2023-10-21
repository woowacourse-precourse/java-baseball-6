package baseball.view;

import baseball.common.CheckResult;

public class Output {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String ALL_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStart() {
        System.out.println(START_GAME);
    }

    public static void printAllCorrect() {
        System.out.println(ALL_CORRECT);
    }

    public static void printResult(CheckResult checkResult) {
        if (checkResult.getStrike() == 0 && checkResult.getBall() == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder sb = new StringBuilder();

        if (checkResult.getBall() > 0) {
            sb.append(checkResult.getBall()).append("볼 ");
        }

        if (checkResult.getStrike() > 0) {
            sb.append(checkResult.getStrike() + "스트라이크");
        }

        System.out.println(sb);
    }
}
