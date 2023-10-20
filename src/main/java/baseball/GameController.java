package baseball;

public class GameController {

    private final InputMessage inputMessage = new InputMessage();
    private final PrintMessage printMessage = new PrintMessage();
    private final RandomNumber randomNumber = new RandomNumber();

    public void run() {
        printMessage.startMessage();
        boolean isStart = true;
        while(isStart) {
            isStart = isStartGame();
        }
    }

    // 메서드명 수정 좀 더 고민해보자
    // 더 쪼개야할 것 같다
    private boolean isStartGame() {
        randomNumber.createNumber();
        boolean isNotCorrect = true;
        while(isNotCorrect) {
            int[] result;
            printMessage.enterNumberMessage();
            String threeNumber = inputMessage.inputThreeNumber();
            result = randomNumber.validateNumber(threeNumber);
            printMessage.resultMessage(result[0], result[1]);
            if (result[1] == 3) {
                isNotCorrect = false;
            }
        }
        printMessage.correctMessage();
        randomNumber.deleteNumber();
        return inputMessage.inputMenuNumber();
    }
}
