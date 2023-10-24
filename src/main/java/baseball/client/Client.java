package baseball.client;

import baseball.console.ConsoleHandler;
import baseball.playGround.PlayGround;

public class Client {

    private final ConsoleHandler consoleHandler;
    boolean start;

    public Client(ConsoleHandler consoleHandler) {
        this.consoleHandler = consoleHandler;
    }

    public void run(){
        start = true;
        consoleHandler.playBallMessage();
        while(start){
            PlayGround playGround = new PlayGround(consoleHandler);
            playGround.playGame();

            start = consoleHandler.chooseRestart();
        }
    }

}
