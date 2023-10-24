package view;

import vo.BallAndStrike;

public class ResultView {
    public static void ballAndStrikePrint(BallAndStrike ballAndStrike) {
        int ball = ballAndStrike.getBall();
        int strike = ballAndStrike.getStrike();

        StringBuilder resultPrint = new StringBuilder();

        resultPrint.append(ballCount(ball));
        resultPrint.append(ballAndStrikeCount(ball, strike));
        resultPrint.append(strikeCount(strike));
        resultPrint.append(nothingCheck(ball, strike));

        System.out.println(resultPrint);
    }

    private static String ballCount(int ball) {
        if (ball != 0) {
            return ball + "볼";
        }
        return "";
    }

    private static String strikeCount(int strike) {
        if (strike != 0) {
            return strike + "스트라이크";
        }
        return "";
    }

    private static String ballAndStrikeCount(int ball, int strike) {
        if ((ball != 0) && (strike != 0)) {
            return " ";
        }
        return "";
    }

    private static String nothingCheck(int ball, int strike) {
        if ((ball == 0) && (strike == 0)) {
            return "낫싱";
        }
        return "";
    }
}
