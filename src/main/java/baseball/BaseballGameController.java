package baseball;

public class BaseballGameController {
    private final BaseballGameService baseballGameService;

    public BaseballGameController() {
        baseballGameService = new BaseballGameService();
    }

    public void run() {
        ConsoleIO.printStartMessage();

        Number computerNumber = baseballGameService.getComputerNumber();
    }
}
