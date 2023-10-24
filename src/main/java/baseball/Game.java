package baseball;

public class Game {

    private Computer computer;
    private Player player;

    public Game(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void run() {
        do {
            play();
        } while (player.restart());
    }

    private void play() {
        computer.makeRandom();
        do {
            player.readPlayerInput();
        } while (!computer.showResult(player.getPlayerInput()));
    }

}
