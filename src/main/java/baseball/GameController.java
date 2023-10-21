package baseball;

public class GameController {
    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private CompareSystem compareSystem;

    public void start() {
        outputView.printStartMessage();
        computer.selectNumbers();
        play();
    }

    public void play() {
        GameResult gameResult;
        boolean isNotThreeStrike = true;
        while (isNotThreeStrike) {
            player.setNumbers(inputView.readNumbers());
            compareSystem = new CompareSystem(computer, player);
            gameResult = compareSystem.compare();
            outputView.printResult(gameResult);
        }
    }
}
