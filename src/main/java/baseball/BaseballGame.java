package baseball;

public class BaseballGame {

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printStartMessage();

        BaseballNumber answer =
                new BaseballNumber(numberGenerator.generate());

        while (true) {
            String input = inputView.readNumber();
            BaseballNumber guess = new BaseballNumber(input);

            GameResult result = answer.compare(guess);
            outputView.printResult(result);

            if (result.isCorrect()) {
                outputView.printCorrectAnswerMessage();
                return;
            }
        }
    }
}
