package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseballGame game = new BaseballGame();

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            game.playGame();
            System.out.print("게임을 다시 시작하시겠습니까? (Y/N): ");
        } while (scanner.next().equalsIgnoreCase("Y"));

        scanner.close();
    }
}
