package baseball.view;

import baseball.domain.Result;

public class OutputView {
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    public static void printResult(Result result){
        System.out.println(createGameResult(result));
    }

    private static String createGameResult(Result result) {
        if (result.isNothing()) return printNothingResult();
        if (result.hasOnlyBalls()) return  printBallsResult(result.getBall());
        if (result.hasOnlyStrikes()) return printStrikesResult(result.getStrike());
        if (result.hasBallsAndStrikes()) return printBallAndStrikeResult(result.getBall(), result.getStrike());
        return EMPTY_STRING;
    }

    private static String printBallAndStrikeResult(int ball, int strike) {
        return new StringBuilder()
                .append(printBallsResult(ball))
                .append(SPACE)
                .append(printStrikesResult(strike))
                .toString();
    }

    private static String printStrikesResult(int strike) {
        return String.format("%d" + STRIKE, strike);
    }

    private static String printBallsResult(int ball) {
        return String.format("%d" + BALL, ball);
    }

    private static String printNothingResult() {
        return NOTHING;
    }

}
