package baseball.domain;

public class Game {
    private final Player player;
    private final Computer computer;
    private final Referee referee;
    private final Printer printer;

    public Game() {
        this.player = new Player();
        this.computer = new Computer();
        this.referee = new Referee();
        this.printer = new Printer();
    }

    public void start() {

    }
}
