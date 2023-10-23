package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;


public class GamePlayer {
    private String playerGuessedNumber;
    private GameStatus playerStatus;
    private Game game;

    public GamePlayer(){
        this.playerStatus = GameStatus.PLAYING;
        this.game = new Game();
    }
    public void playGameByRequest(){
        while(playerStatus == GameStatus.PLAYING){
            this.playerGuessedNumber = Console.readLine();
            if (isValidForm(this.playerGuessedNumber)){
                this.playerStatus = game.comparePlayerNumberWithComputer(this.playerGuessedNumber);
                sendNumberToGame(this.playerGuessedNumber);
            }
            else{
                throw new IllegalArgumentException();
            }
        }
    }


    public boolean isValidForm(String target){
        boolean flag = true;
        if (target.length() != 3){
            flag = false;
        }
        for (int i = 0; i < target.length(); i++){
          if (!Character.isDigit(target.charAt(i)))
              flag = false;
        }
        return flag;
    }

}
