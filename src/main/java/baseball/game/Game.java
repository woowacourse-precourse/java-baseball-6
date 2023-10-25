package baseball.game;

import baseball.computer.Computer;
import baseball.message.Message;
import baseball.player.Player;

public class Game {
    private Computer computer;
    private Player player;

    public Game() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void start() {
        while (true) {
            String playerNum = player.input();
            if (computer.isCorrect(playerNum)) {
                System.out.println(Message.CORRECT_ANSWER);
                break;
            }
        }
    }
}
