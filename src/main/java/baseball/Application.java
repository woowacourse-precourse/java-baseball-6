package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 본 게임
        Scanner scanner = new Scanner(System.in);
        PlayBaseball playBaseball = new PlayBaseball();
        boolean playAgain = true;

        System.out.print("숫자 야구 게임을 시작합니다.\n");
        while (playAgain) {
            playBaseball.playBall2();
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (scanner.nextInt() == 2){
                playAgain = false;
            }
        }
        System.out.print("숫자 야구 게임을 종료합니다.");
    }
}
