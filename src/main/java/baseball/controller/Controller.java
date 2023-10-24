package baseball.controller;

import baseball.service.GameService;
import baseball.view.GameMessage;
import baseball.view.RequestMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    final int MIN=1;
    final int MAX=9;
    final int SIZE=3;
    final int RESTART=1;
    final int EXIT=2;

    GameService gameService=new GameService();
    public void run() throws IllegalArgumentException{
        setGame();
        playGame();
        completeGame();
        restartGame();
    }

    private void setGame(){
        gameService.setGame(MIN,MAX,SIZE);
    }
    private void playGame(){
        gameService.startGame();
    }
    private void completeGame() {
        GameMessage.printGameCompleteMessage();
    }

    private void restartGame() throws IllegalArgumentException{
        RequestMessage.requestExit();
        if(getExitCode()==RESTART)
            run();
    }
    private int getExitCode() throws IllegalArgumentException{
        int playerInput=Integer.parseInt(Console.readLine());

        if(!(playerInput==RESTART||playerInput==EXIT)){
            throw new IllegalArgumentException();
        }

        return playerInput;
    }
}
