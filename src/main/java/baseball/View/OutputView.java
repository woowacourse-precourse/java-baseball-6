package baseball.View;

import baseball.Model.Referee;

import java.util.Map;

public class OutputView {

    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다!";
    public static final String GAME_SET_MESSAGE = "게임 종료";
    public static final int ZERO = 0;

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

        if (strike == ZERO && ball == ZERO) {
            return NOTHING;
        }
        else if (strike == ZERO) {
            return ball+BALL;
        }
        else if (ball == ZERO) {
            return strike+STRIKE;
        }
        return ball+BALL+" "+strike+STRIKE;
    }

    public static void printCorrectMessage() {
        System.out.println(CORRECT_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(GAME_SET_MESSAGE);
    }
}
