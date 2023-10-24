package baseball;

import java.util.List;

class Message{
    public static final String START = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT = "숫자를 입력해주세요 : ";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String MATCH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
}

public class OutputView {

    public static void printStart() {
        System.out.println(Message.START);
    }

    public static void printInput() {
        System.out.println(Message.INPUT);
    }

    public static void printResult(List<Integer> ballCount) {
        int ball = ballCount.get(0);
        int strike = ballCount.get(1);
        if (ball == 0 && strike == 0) {
            System.out.println(Message.NOTHING);
            return;
        }
        System.out.println(ball + Message.BALL + " " + strike + Message.STRIKE);
    }

    public static void printRestart() {
        System.out.println(Message.MATCH);
        System.out.println(Message.RESTART);
    }

}
