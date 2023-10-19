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
        try{ // input이 문자인 경우를 대비
            int gameRetry = Integer.parseInt(input);
            if(gameRetry <= 0 || gameRetry >= 3){
                throw new IllegalArgumentException();
            }
            return gameRetry;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

}
