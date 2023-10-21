package baseball;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");

        final BaseBall baseBall = new BaseBall(3);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("숫자를 입력해주세요 : ");
                List<Integer> player = NumberParser.parseIntegerList(scanner.next());
                baseBall.doGame(player);

                if (baseBall.isOver()) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int operation = NumberParser.parseSingleDigitNumber(scanner.next());
                    if (operation == 1) {
                        baseBall.newGame();
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
