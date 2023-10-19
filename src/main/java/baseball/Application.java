package baseball;

import baseball.Input.InputAnswer;
import baseball.Input.InputAnswerImpl;

import static java.lang.System.*;


public class Application {

    private static final String startupMessage = "숫자 야구 게임을 시작합니다.";
    private static final InputAnswer inputAnswer = new InputAnswerImpl();

    public static void main(String[] args) {
        out.println(startupMessage);
        try{
            inputAnswer.inputAnswer();
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
            throw e;
        }
    }
}
