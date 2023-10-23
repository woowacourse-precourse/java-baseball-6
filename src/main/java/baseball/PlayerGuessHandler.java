package baseball;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayerGuessHandler implements PlayerInputHandler<Iterator<Integer>> {
    private ArrayList<Integer> playerGuessNumberList;
    public PlayerGuessHandler(){

    }
    public void handle(String playerGuessNumbers){
        playerGuessNumberList = new ArrayList<>();

        checkLengthValidity(playerGuessNumbers.length());

        for (int playerGuessIndex = 0; playerGuessIndex < playerGuessNumbers.length(); playerGuessIndex++){
            char characterNumber = playerGuessNumbers.charAt(playerGuessIndex);

            isCharNumberInRange(characterNumber);

            int playerGuessNumber = characterNumber - '0';
            isInList(playerGuessNumber);
            playerGuessNumberList.add(playerGuessNumber);
        }
    }

    private void checkLengthValidity(int playerGuessLength){
        if (playerGuessLength != GameSettings.NUM_DIGITS){
            throw new IllegalArgumentException();
        }
    }
    private void isInList(int playerGuessNumber){
        if (playerGuessNumberList.contains(playerGuessNumber)){
            throw new IllegalArgumentException();
        }
    }
    private void isCharNumberInRange(char charNumber){

        if (charNumber < GameSettings.MIN_INPUT_CHARACTER || charNumber > GameSettings.MAX_INPUT_CHARACTER){
            throw new IllegalArgumentException();
        }
    }

    public Iterator<Integer> getHandledResult(){
        return playerGuessNumberList.iterator();
    }
}
