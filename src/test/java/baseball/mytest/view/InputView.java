package baseball.mytest.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    public String getUserInput() {
        InputStream in = generateUserInput("123");
        System.setIn(in);
        Scanner sc = new Scanner(System.in);

        return sc.next();
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
