package baseball.controller;

public class OutputController {

    public final static String START = "숫자 야구 게임을 시작합니다.";
    public final static String INPUT = "숫자를 입력해주세요 : ";

    public final static String AFTER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String STRIKE = "스트라이크";
    public final static String BALL = "볼";
    public final static String ANSWER ="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public void cliOutputln(String ment) {
        System.out.println(ment);
    }

    public void cliOutput(String ment) {
        System.out.print(ment);
    }
}
