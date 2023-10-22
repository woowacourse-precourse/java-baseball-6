package baseball;

public class Application {
    public static void main(String[] args) {
        // 게임 시작 전
        Computer computer = new Computer();
        Player player = new Player();
        Judge judge = new Judge();

        Game game = new Game(computer, player, judge);

        while (true) {
            game.start();

            if (!game.isRestart()) break;
        }
    }
}
