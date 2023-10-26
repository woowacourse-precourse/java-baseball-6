package baseball.view;

public class NumberBaseballGameOutputView {

    public void printStartGameMessage() {
        NumberBaseballOutPutMessage.START_GAME.print();
    }

    public void printNumberInputRequest() {
        NumberBaseballOutPutMessage.NUMBER_INPUT_REQUEST.print();
    }

    public void printScoreSummary(String result) {
        System.out.println(result);
    }

    public void printGameOverMessage() {
        askForGameRestart();
        NumberBaseballOutPutMessage.GAME_OVER.print();
    }

    public void askForGameRestart() {
        NumberBaseballOutPutMessage.GAME_RESTART.print();
    }


}
