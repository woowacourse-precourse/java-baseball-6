package baseball.gameProcess;

import java.util.Scanner;

public class inProcess {
    int number;

    public inProcess() {
        printInputNumberPhrase();
        inputNumber();
        checkNumberThree();
        checkNumberOneToNineDifferent();
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

    private void checkNumberThree() {
        if (String.valueOf(number).length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberOneToNineDifferent() {
        boolean[] exist = new boolean[10];
        int share = number;
        int remain;

        for (int i = 0; i < String.valueOf(number).length(); i++) {
            remain = share % 10;
            share /= 10;

            if (remain == 0 || exist[remain]) {
                throw new IllegalArgumentException();
            }
            exist[remain] = true;
        }
    }
}
