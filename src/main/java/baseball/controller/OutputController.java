package baseball.controller;

public class OutputController {

    public final static String START = "숫자 야구 게임을 시작합니다.";
    public final static String INPUT = "숫자를 입력해주세요 : ";

    public final static String AFTER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String STRIKE = "스트라이크";
    public final static String BALL = "볼";
    public final static String NOTHING = "낫싱";
    public final static String ANSWER ="3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    //줄띄움있는 멘트 출력
    public void printNoticeln(String ment) {
        System.out.println(ment);
    }

    //줄띄움 없는 멘트 출력
    public void printNotice(String ment) {
        System.out.print(ment);
    }

    //결과 출력
    public void printResult(int strike,int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ball != 0) {
            System.out.print(ball + BALL);
        }

        if (strike == 0) {
            System.out.println("");
            return;
        } else {
            System.out.print(" ");
        }
        System.out.println(strike + STRIKE);

    }
}
