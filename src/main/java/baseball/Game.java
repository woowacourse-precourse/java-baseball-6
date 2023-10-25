package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Arrays;

public class Game {

    private Computer computer;

    public Game() {
        OutputView.printStartPhrase();
    }

    public void run() {
        computer = new Computer();
        computer.generateRandomNumber();

        progressNumberInput();
        OutputView.printExitPhrase();

        selectExitOption();
    }

    private void progressNumberInput() {
        do {
            Judgement.initCount();
            OutputView.printNumberInputPhrase();
            String input = InputView.inputUniqueDigit();

            int[] convertedInput = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
            computer.checkAnswer(convertedInput);
            OutputView.printJudgeState();
        } while (!Judgement.isWin());
    }

    private void selectExitOption() {
        OutputView.printExitOptionPhrase();
        String option = InputView.inputExitOption();
        boolean wantRestart = option.equals("1");
        if (wantRestart) {
            run();
            return;
        }
        OutputView.printExit();
    }
}
