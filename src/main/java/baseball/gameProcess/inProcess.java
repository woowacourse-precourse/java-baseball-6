package baseball.gameProcess;

import java.util.Scanner;

public class inProcess {
    int number;

    public inProcess() {
        printInputNumberPhrase();
        inputNumber();
    }

    private void printInputNumberPhrase() {
        System.out.print(inNotice.inputNumberPhrase);
    }

    private void inputNumber() {
        Scanner sc = new Scanner(System.in);

        try {
            number = sc.nextInt();
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
