package baseball.view;

import baseball.domain.BallList;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {

    private static final int MAX_STRIKE = 3;
    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT = "숫자를 입력해주세요 : ";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING = "낫싱";

    public BallList getInput() {
        System.out.println(INPUT);
        String origin = Console.readLine();
        return new BallList(origin);
    }

    public void displayResult(int ballCount, int strikeCount) {
        if (ballCount > 0 && strikeCount == 0) {
            printOnlyBall(ballCount);
        } else if (strikeCount == MAX_STRIKE) {
            printEnd();
        } else if (ballCount == 0 && strikeCount > 0) {
            printOnlyStrike(strikeCount);
        } else if (ballCount > 0 && strikeCount > 0) {
            printBallAndStrike(ballCount, strikeCount);
        } else {
            printNothing();
        }
    }

    public void displayStart() {
        System.out.println(START);
    }

    private void printOnlyStrike(int strikeCount) {
        System.out.println(strikeCount + STRIKE);
    }

    private void printNothing() {
        System.out.println(NOTHING);
    }

    private void printBallAndStrike(int ballCount, int strikeCount) {
        System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
    }

    private void printEnd() {
        System.out.println(MAX_STRIKE + STRIKE);
        System.out.println(END);
    }

    private void printOnlyBall(int ballCount) {
        System.out.println(ballCount + BALL);
    }

    public String getChoice() {
        return Console.readLine();
    }

}
