package baseball;

public class Game {
    public static void runGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        computer.createRandomNumber();
        Player player = new Player();
        player.input();
    }
}