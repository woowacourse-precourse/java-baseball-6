package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    GameException exception = new GameException();

    public String inputPlayerNumber() {
        String inputPlayerNumber = Console.readLine();
        inputPlayerNumberException(inputPlayerNumber);
        return inputPlayerNumber;
    }

    public int inputPlayerRetryNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private void inputPlayerNumberException(String inputPlayerNumber) {
        exception.playerNumberLengthException(inputPlayerNumber);
        exception.playerNumberTypeException(inputPlayerNumber);
    }
}