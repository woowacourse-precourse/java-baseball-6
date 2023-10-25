package baseball.view;

import baseball.game.Balls;

import java.util.Scanner;

public class InputView {

    private String inputNumber;
    public Balls getInputs() {
        System.out.println("숫자를 입력해주세요 : ");
        inputNumber = SharedScanner.scanner.next();
        return new Balls(inputNumber);
    }
}
