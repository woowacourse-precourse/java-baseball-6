package baseball;

public class GameService {
    OutPutView outPutView = new OutPutView();
    InputView inputView = new InputView();
    GameException exception = new GameException();

    public int[] inputPlayerNumber() {
        outPutView.printRequestInputNumberMessage();
        String inputPlayerNumber = inputView.inputPlayerNumber();
        return toIntArray(inputPlayerNumber);
    }

    private int[] toIntArray(String inputPlayerNumber) {
        int[] playerNumbers = new int[inputPlayerNumber.length()];
        for (int i = 0; i < inputPlayerNumber.length(); i++) {
            char storeNumber = inputPlayerNumber.charAt(i);
            exception.playerNumberDuplicateException(playerNumbers, storeNumber);
            playerNumbers[i] = toInt(storeNumber);
        }
        return playerNumbers;
    }

    static int toInt(char storeNumber) {
        return storeNumber - '0';
    }
}
