package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static baseball.domain.Computer.NUMBER_SIZE;

import baseball.domain.Hint;
import java.util.Collections;
import java.util.List;

public class Outputview {

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String END_MESSAGE = "게임 종료";

    private Outputview() {
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printSuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public static void printHintList(List<Hint> hintList) {
        String result = "";
        String resultStrike = "";
        String resultBall = "";
        Integer StrikeCount = Collections.frequency(hintList, Hint.STRIKE);
        Integer BallCount = Collections.frequency(hintList, Hint.BALL);

        if (StrikeCount != 0) {
            resultStrike = StrikeCount.toString() + Hint.STRIKE.getInKorean();
        }
        if (BallCount != 0) {
            resultBall = BallCount.toString() + Hint.BALL.getInKorean() + " ";
        }
        if (BallCount == 0 && StrikeCount == 0) {
            result += Hint.NOTHING.getInKorean();
        }
        result += (resultBall + resultStrike);
        System.out.println(result);
    }
}