package baseball;

import java.util.Scanner;

public class RestartGame {
    public boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            int restart = sc.nextInt();
            if (restart == 1) {
                return true;
            } else if (restart !=2) {
                throw new IllegalArgumentException("");
            }
        } catch (IllegalArgumentException e){
            System.exit(1);
        }
        return false;
    }
}
