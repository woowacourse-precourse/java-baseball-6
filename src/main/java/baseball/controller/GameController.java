package baseball.controller;


import baseball.view.OutputMessage;

public class GameController {

    OutputMessage outputMessage = new OutputMessage();

    public void startGame() {
        outputMessage.printGameStartMessage();
    }

}
