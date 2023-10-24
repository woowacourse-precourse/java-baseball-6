package baseball.view;

import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);

    public String getUserInput() {
        return sc.next();
    }
}