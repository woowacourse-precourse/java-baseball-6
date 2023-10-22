package baseball.controller;

public class OutputController {

    public final static String START = "숫자 야구 게임을 시작합니다.";
    public final static String INPUT = "숫자를 입력해주세요 : ";

    public void cliOutputln(String ment) {
        System.out.println(ment);
    }

    public void cliOutput(String ment) {
        System.out.print(ment);
    }
}
