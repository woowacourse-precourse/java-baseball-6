package baseball;

public class BaseballGame {
    private final Computer computer;
    private final Player player;


    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void run() {
        initiallizeGame();
    }

    public void initiallizeGame() {
        computer.createRandomPicks();
        player.makePicks();
    }

    public void playGame() {

    }


}
