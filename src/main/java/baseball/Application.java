package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    private static void startGame() {
        Computer computer = new Computer();
        Player player = new Player();
        System.out.print("숫자를 입력해주세요 : ");
        player.setPlayerNumber(Console.readLine());
    }
}
