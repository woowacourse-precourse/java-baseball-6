package baseball.domain;

public class Game extends BaseBallGameRule {

    private final GameComputer computer;
    private final GamePlayer player;

    private Game() {
        this.computer = Computer.startComputer();
        this.player = Player.readyPlayer();
    }

    public static Game startGame() {
        return new Game();
    }

    public void showResult() {
        this.progressGame();
    }

    public void progressGame() {
        player.fight((Computer) this.computer);
    }

    public Boolean askRestart() {
        return player.checkFinishGame();
    }
}
