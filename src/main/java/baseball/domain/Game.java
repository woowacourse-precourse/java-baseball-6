package baseball.domain;

public class Game {
    private final Player player;
    private final Computer computer;
    private final Printer printer;

    public Game() {
        this.player = new Player();
        this.computer = new Computer();
        this.printer = new Printer();
    }

    public void start() {
        printer.printStartMessage();
        proceed();
        printer.printEndMessage();
    }

    private void proceed() {
        computer.pickBalls();

        while (true) {
            printer.printInputMessage();
            Ball playerBalls = player.pickBalls();
            StrikeBallCount strikeBallCount = computer.compare(playerBalls);
            if (strikeBallCount.strike() == 3) {
                break;
            }
            printer.printResult(strikeBallCount);
        }
    }
}
