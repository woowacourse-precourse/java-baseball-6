package baseball;

import java.util.List;

public class BaseballGamePlayer implements GamePlayer {
    private Printer printer;
    private RandomNumbersGenerator randomNumbersGenerator;
    private JudgeMachine judgeMachine;
    private Configurations config;
    private Scanner scanner;

    @Override
    public void run() {
        printer.printStartMessage();
        Integer option = config.getPlayOption();
        while (continueGame(option)) {
            playGame();
            option = scanner.inputReplayOption();
            printer.printReplayMessage();
        }
    }

    public BaseballGamePlayer() {
        printer = new Printer();
        judgeMachine = new JudgeMachine();
        config = new Configurations();
        scanner = new Scanner(config);
        randomNumbersGenerator = new RandomNumbersGenerator(config);
    }

    private Boolean continueGame(Integer option) {
        return option.equals(config.getPlayOption());
    }

    private void playGame() {
        List<Integer> targetNumbers = randomNumbersGenerator.generate();
        BaseballForm result = new BaseballForm();
        while (!result.getCorrect()) {
            printer.printGuessNumMessage();
            List<Integer> userNumbers = scanner.inputUserNumber();
            result = judgeMachine.judge(targetNumbers, userNumbers, config.getNumberOfNumbers());
            printer.printScore(result);
        }
    }


}
