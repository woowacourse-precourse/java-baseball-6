package baseball.Game;

import baseball.Computer.Computer;
import baseball.Player.Player;
public class Game {

    private final Computer computer;
    private final Player player;

    public Game() {

        this.computer = new Computer();
        this.player = new Player();
    }

    public void showResult() {

        player.playing(this.computer);
    }

    public Boolean askRestart() {

        return player.checkRestart();
    }


}
