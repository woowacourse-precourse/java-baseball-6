package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final GameException gameException;

    public InputView(GameException gameException) {
        this.gameException = gameException;
    }

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
        gameException.playerNumberLengthException(inputPlayerNumber);
    }

    private void validatePlayerNumberType(String inputPlayerNumber) {
        gameException.playerNumberTypeException(inputPlayerNumber);
    }
}