package baseball.View;

import baseball.Model.Referee;

import java.util.Map;

public class OutputView {

    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printJudgement(Map<String,Integer> judgement) {
        String judgementMessage = makeJudgementMessage(judgement);
        System.out.println(judgementMessage);
    }

    private static String makeJudgementMessage(Map<String, Integer> judgement) {
        int strike = judgement.get(Referee.STRIKE);
        int ball = judgement.get(Referee.BALL);

        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        else if (strike == 0) {
            return ball+BALL;
        }
        else if (ball == 0) {
            return strike+STRIKE;
        }
        return ball+BALL+" "+strike+STRIKE;
    }

    public static void printCorrectMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다!");
    }

    public static void printEndMessage() {
        System.out.println("게임 종료");
    }
}
