package baseball;

import java.util.Scanner;

public class User {
    Scanner scanner = new Scanner(System.in);
    int inputNum = 0;
    int[] result;

    public void Gameover() {
        System.exit(0);
    }
    public int[] input() {
        System.out.print("숫자를 입력해주세요 : ");

        try {
            inputNum = scanner.nextInt();
        } catch (IllegalArgumentException e) {
            Gameover();
        }
        return result;
    }
}
