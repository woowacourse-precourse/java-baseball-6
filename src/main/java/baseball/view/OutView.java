package baseball.view;

import baseball.BallResultDto;

public class OutView {
    public static void gameStartPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void numberInputPrint() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void ballScoringResultsPrint(BallResultDto ballResultDto) {
        System.out.println(convertBallResultToString(ballResultDto));
    }

    public static void endGamePrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void restartGamePrint() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static String convertBallResultToString(BallResultDto ballResultDto) {
        if (ballResultDto.getBall() == 0 && ballResultDto.getStrike() == 0) {
            return "낫싱";
        }
        StringBuilder result = new StringBuilder();
        if (ballResultDto.getBall() > 0) {
            result.append(ballResultDto.getBall()).append("볼 ");
        }
        if (ballResultDto.getStrike() > 0) {
            result.append(ballResultDto.getStrike()).append("스트라이크");
        }
        return result.toString();
    }
}
