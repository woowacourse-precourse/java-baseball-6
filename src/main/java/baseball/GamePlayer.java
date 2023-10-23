package baseball;

import camp.nextstep.edu.missionutils.Console;


public class GameParticipant {
    private String playerGuessedNumber;
    private GameStatus playerStatus;
    private GameManager game;

    public GamePlayer(){
        this.playerStatus = GameStatus.PLAYING;
        this.game = new GameManager();
    }
    public void playGameByRequest(){
        while(playerStatus == GameStatus.PLAYING){
            this.playerGuessedNumber = Console.readLine();
            if (isValidForm(this.playerGuessedNumber)){
                game.setPlayerGuessedNumber(this.playerGuessedNumber);
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
