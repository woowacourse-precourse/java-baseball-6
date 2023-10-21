package baseball;

import java.util.Scanner;

public class WhetherRestart {
    int gameEndNumber;
    void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    void scanGameEndNumber() {
        Scanner scan = new Scanner(System.in);
        gameEndNumber = scan.nextInt();
    }
}
