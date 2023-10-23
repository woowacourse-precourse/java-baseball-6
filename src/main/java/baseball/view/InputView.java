package baseball.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private InputView() {
    }

    public static String getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
