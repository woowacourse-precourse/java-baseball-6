package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            Game.playBaseballGame();
            
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(Console.readLine());

            if (choice == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }
}
