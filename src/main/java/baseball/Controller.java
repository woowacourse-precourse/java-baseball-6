package baseball;

import baseball.service.GameService;
import baseball.view.ControllerMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    private final int GAME_RETRY = 1;
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;
    private final int COUNT = 3;

    private GameService gameService = new GameService();

    public Controller(){
        ControllerMessage.startMessage();
    }

    public void run(){
        setGame();
        playGame();
        endGame();
        retryGame();
    }

    public void setGame(){
        gameService.setGame(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }

    public void playGame() {
        gameService.playGame();
    }

    public void endGame() {
        ControllerMessage.endMessage();
    }

    public void retryGame() throws IllegalArgumentException{
        ControllerMessage.retryMessage();
        if(inputRetryValid() == GAME_RETRY){
            run();
        }
    }

    public int inputRetryValid() throws IllegalArgumentException{
        String input = Console.readLine();
        if(input.length() != 1){
            throw new IllegalArgumentException();
        }
        char c = input.charAt(0);
        if(c < '1' || c > '2'){
            throw new IllegalArgumentException();
        }
        return c - '0';
    }

}
