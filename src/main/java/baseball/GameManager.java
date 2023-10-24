package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameManager {
    private String playerGuessedNumber;
//    private GameCompititor counterPlayer;
    private GameStatus gameStatus;

    public GameManager(){
//        this.computerGuessedNumber = new GameCompititor();
    }

    public GameStatus processTurn(String playerNumber){
        if (this.isValidForm(playerNumber)){
            this.playerGuessedNumber = playerNumber;
            gameStatus = compareBetweenNumbers(this.playerGuessedNumber);
        }
        else {
            throw new IllegalArgumentException();
        }
        return gameStatus;
    }
//    public GameStatus compareBetweenNumbers(String playerNomber){
//
//    }
    public boolean isValidForm(String target){
        boolean flag = true;
        Set<Object> set = new HashSet<>();

        if (target.length() != 3){
            flag = false;
        }
        for (int i = 0; i < target.length(); i++){
            char indexValue = target.charAt(i);
            if (!Character.isDigit(indexValue) || !(('0' < indexValue)&&(indexValue < '9')))
                flag = false;

            if(!set.add(indexValue)){
                flag = false;
            }
        }

        return flag;
    }
}
