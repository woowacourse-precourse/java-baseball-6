package baseball.io;

import baseball.dto.Score;

public class ConsoleOutput {

    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void printFail(Score score) {
        StringBuilder sb = new StringBuilder();
        if (score.isNothing()) {
            sb.append("낫싱");
        }
        if (score.getBall() != 0) {
            sb.append(score.getBall()).append("볼 ");
        }
        if (score.getStrike() != 0) {
            sb.append(score.getStrike()).append("스트라이크");
        }


        System.out.println(sb.toString());
    }

    public static void printResult(Score score) {
        if (score.getStrike() == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        printFail(score);
    }
}
