package baseball.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public String inputNumbers() throws IOException {
        return input("숫자를 입력해주세요 : ");
    }
    public String inputRestart() {
        return null;
    }
    public String inputGameMode() {
        return null;
    }
    private String input(String message) throws IOException {
        printMessage(message);
        return br.readLine();
    }
    private void printMessage(String message) {
        System.out.print(message);
    }
}
