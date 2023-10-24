package baseball;

public class Application {
    public static void main(String[] args) {
        while (true) { //
            Computer computer = new Computer();
            Player player = new Player();
            Judge judge = new Judge();

            Game game = new Game(computer, player, judge);
            game.start();

            if (judge.checkRestart(player)) break; //
        }
    }
}
