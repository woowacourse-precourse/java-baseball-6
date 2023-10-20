package baseball.View;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String inputNumberMsg = "숫자를 입력해주세요 : ";
    private static final String afterGameMsg = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public String enterAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine();
        return answer;
    }

    public void enterAskNumber() throws IOException {
        System.out.println(inputNumberMsg);
        enterAnswer();
    }

    public void enterAskRestart() throws IOException {
        System.out.println(afterGameMsg);
        enterAnswer();
    }
}
