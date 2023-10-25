package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User extends Number {

    private static int strikeCount;
    private static int ballCount;

    private static final String INPUTREQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String KEYWORD_BALL = "볼";
    private static final String KEYWORD_NOMATCH = "낫싱";
    private static final String KEYWORD_STRIKE = "스트라이크";
    private static final String CELEBRATION_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_KEY = "1";
    private static final String QUIT_KEY = "2";

    User() {
        resetCounts();
    }

    public static Number getInputNums() {
        System.out.print(INPUTREQUEST_MESSAGE);
        String input = Console.readLine();
        return new Number(input);
    }

    public static void resetCounts() {
        strikeCount = 0;
        ballCount = 0;
    }

    public static void printResult() {
        if(strikeCount + ballCount == 0) {
            System.out.println(KEYWORD_NOMATCH);
            return;
        }

        List<String> message = new ArrayList<>();

        if(ballCount > 0) {
            message.add(ballCount+KEYWORD_BALL);
        }

        if(strikeCount > 0) {
            message.add(strikeCount+KEYWORD_STRIKE);
        }

        System.out.println(String.join(" ", message));
    }

    public static void addBallCount() {
        ballCount++;
    }

    public static void addStrikeCount() {
        strikeCount++;
    }
}
