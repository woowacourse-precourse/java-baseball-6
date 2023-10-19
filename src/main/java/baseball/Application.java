package baseball;

import java.util.Scanner;

public class Application {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String number = requestNumber();
    }

    public static String requestNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        return input;
    }
}
