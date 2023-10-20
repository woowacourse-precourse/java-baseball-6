package baseball;

public class Baseball {

    private final PrintMessage printMessage = new PrintMessage();
    void run(){
        printMessage.gameStartMessage();
        startGame();
    }

    void startGame(){
        printMessage.inputNumberMessage();
        printMessage.gameResult(1,1);
        printMessage.inputNumberMessage();
        printMessage.gameResult(0,3);
        printMessage.gameCommand();
    }
}
