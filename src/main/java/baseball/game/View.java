package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private static final String OPENING_LINE = "숫자 야구 게임을 시작합니다.";
    private static final String QUESTION_LINE = "숫자를 입력해주세요 : ";
    private static final String CLOSING_LINE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REPLAY_LINE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public void printHint(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ball > 0) {
            System.out.print(ball + BALL);
        }
        if (strike > 0) {
            System.out.print(strike + STRIKE);
        }
        System.out.println();
    }

    public void printStart(){
        System.out.println(OPENING_LINE);
    }

    public void printEnd(){
        System.out.println(CLOSING_LINE);
    }

    public String readUser(){
        System.out.print(QUESTION_LINE);
        return Console.readLine();
    }

    public String readReplayCommand(){
        System.out.print(REPLAY_LINE);
        return Console.readLine();
    }
    
}
