package baseball;

import baseball.Service.PlayballGame;
import baseball.View.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    PlayballGame playballGame = new PlayballGame();

    public void run() {
        readyGame();
        gamePlay();
        gameReplay();
    }


    //게임 세팅
    public void readyGame(){
        playballGame.readyGame();
        }
    public void gamePlay(){
        playballGame.gamePlay();
    }
    public  void gameReplay()throws IllegalArgumentException{
        GameMessage.restartMessage();
        int userSelect = Integer.parseInt(Console.readLine());
        if(userSelect !=1 && userSelect !=2){
            throw new IllegalArgumentException();
        }
        if(userSelect == 1){
            run();
        }
    }
}
