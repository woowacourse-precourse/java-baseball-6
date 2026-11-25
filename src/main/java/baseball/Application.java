package baseball;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printStartMessage();

        InputView inputView = new InputView();
        String input = inputView.readNumber();

        BaseballNumber playerNumber = new BaseballNumber(input);
    }
}
