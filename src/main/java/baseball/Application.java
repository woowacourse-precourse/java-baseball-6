package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");
        game.gameStart();
        while (true) {
            int select = game.menu();
            switch (select) {
            case 1 :
                game.gameStart();
                break;
            case 2 :
                System.out.println("게임을 종료합니다.");
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 값을 입력하였습니다.");
                break;
            }
        }
    }
}
