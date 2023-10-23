package baseball;

public class Game {
    private Input input;
    private Output output;
    private BallCount ballCount;
    private Computer computer;
    private User user;

    public Game() {
        this.input = new Input();
        this.output = new Output();
        this.ballCount = new BallCount();
        this.computer = new Computer();
        this.user = new User();
    }

    public void play() {
        output.printStartMessage();
        computer.generateRandomNumber();
        while (true) {
            output.printInputMessage();
            user.storeUserNumber(input.readUserNumber());
            ballCount.calculate(computer.getRandomNumbers(), user.getUserNumber());
            output.printGameResult(ballCount.getStrikeCount(), ballCount.getBallCount());
            if (ballCount.getStrikeCount() == 3) {
                output.printGameEndMessage();
                output.printRestartMessage();
                if (!input.isRestart()) {
                    break;
                }
                computer.generateRandomNumber();
            }
        }
    }
}
