package baseball;

public class OutputView {
    public void printStartMessage() {
        System.out.println(ProcessMessage.START_MESSAGE);
    public void printResult(GameResult gameResult) {
        if (gameResult.hasThreeStrike()) {
            printThreeStrikeResult();
            return;
        }
        printBallAndStrikeResult(gameResult);
    }

    private void printThreeStrikeResult() {
        System.out.println(ProcessMessage.THREE_STRIKE);
    }

}
