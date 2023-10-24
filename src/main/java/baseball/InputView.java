package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public Numbers getUserNumbers() {
        OutputView.printNumberInputText();
        NumberInput numberInput = new NumberInput(Console.readLine().trim());
        return numberInput.getNumbers();
    }

    public boolean getRestartInput() {
        OutputView.printRestartInputText();
        return getOneOrTwo(Console.readLine());
    }

    private boolean getOneOrTwo(String userInput) {
        String trimUserInput = userInput.trim();
        RestartInput restartInput = new RestartInput(trimUserInput);
        if (restartInput.isOne()) {
            return true;
        }
        OutputView.printEndText();
        return false;
    }

    public void close() {
        Console.close();
    }
}
