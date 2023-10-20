package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    GameException exception = new GameException();

    public String inputPlayerNumber() {
        String inputPlayerNumber = Console.readLine();
        validatePlayerNumber(inputPlayerNumber);
        return inputPlayerNumber;
    }

    public int inputPlayerRetryNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private void validatePlayerNumber(String inputPlayerNumber) {
        validatePlayerNumberLength(inputPlayerNumber);
        validatePlayerNumberType(inputPlayerNumber);
    }

    private void validatePlayerNumberLength(String inputPlayerNumber) {
        exception.playerNumberLengthException(inputPlayerNumber);
    }

    private void validatePlayerNumberType(String inputPlayerNumber) {
        exception.playerNumberTypeException(inputPlayerNumber);
    }
}