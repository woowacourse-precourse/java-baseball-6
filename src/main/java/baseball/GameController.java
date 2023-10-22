package baseball;

public class GameController {

    private static final String START_GAME_OPTION = "1";
    private final InputMessage inputMessage = new InputMessage();
    private final InputValidation inputValidation = new InputValidation();
    private final PrintMessage printMessage = new PrintMessage();

    public void run() {
        printMessage.startMessage();
        boolean isStart = true;
        while (isStart) {
            isStart = isStartGame();
        }
    }

    private boolean isStartGame() {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.generateRandomNumber();

        boolean isNotCorrect = true;
        while (isNotCorrect) {
            printMessage.enterNumberMessage();
            String threeNumber = inputMessage.inputThreeNumber();
            inputValidation.validateNumber(threeNumber);
            int[] result = randomNumber.checkInputNumbers(threeNumber);
            printMessage.resultMessage(result[0], result[1]);
            if (result[1] == 3) {
                isNotCorrect = false;
            }
        }
        printMessage.correctMessage();
        printMessage.menuMessage();
        String optionNumber = inputMessage.inputOptionNumber();
        inputValidation.validateOptionNumber(optionNumber);
        if (optionNumber.equals(START_GAME_OPTION))
            return true;
        return false;
    }
}
