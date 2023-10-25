package message;

import static rules.BaseballRules.hasBallButNoStrike;
import static rules.BaseballRules.hasStrikeAndBall;
import static rules.BaseballRules.hasStrikeButNoBall;
import static rules.BaseballRules.noStrikeAndBall;

import score.BaseballScore;

public class Message {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private Message() {
    }

    public static void printIntegerInputFromUserMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printContinueOrFinishMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printThreeStrikeMessage() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다!");
        System.out.print(" ");
        System.out.println("게임 종료");
    }

    public static void printEndGameMessage() {
        System.out.println("게임 종료");
    }

    public static void printHintMessage(BaseballScore score) {
        int strike = score.getStrike();
        int ball = score.getBall();

        if (hasStrikeAndBall(strike, ball)) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
        if (hasStrikeButNoBall(strike, ball)) {
            System.out.println(strike + STRIKE);
        }
        if (hasBallButNoStrike(strike, ball)) {
            System.out.println(ball + BALL);
        }
        if (noStrikeAndBall(strike, ball)) {
            System.out.println(NOTHING);
        }
    }

    public static void printErrorMessage() {
        System.out.println("잘못된 입력입니다.");
    }
}
