package baseball;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        // TODO: 프로그램 구현
        gameStart(computer, player);
    }

    private static void gameStart(Computer computer, Player player) {
        computer.pickRandomNumber();
        System.out.println("게임 시작");
        int command = 1;
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            int[] playerNumber = player.pickPlayerNums();
        }
    }
}
