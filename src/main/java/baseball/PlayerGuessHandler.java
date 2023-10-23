package baseball;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayerGuessHandler implements PlayerInputHandler<Iterator<Integer>> {
    private ArrayList<Integer> playerGuessNumberList;
    public PlayerGuessHandler(){

    }
    public void handle(String playerGuessNumbers){
        this.playerGuessNumberList = new ArrayList<>();

        if (playerGuessNumbers.length() != GameSettings.NUM_DIGITS){
            throw new IllegalArgumentException();
        }

        for (int playerGuessIndex = 0; playerGuessIndex < playerGuessNumbers.length(); playerGuessIndex++){
            char characterNumber = playerGuessNumbers.charAt(playerGuessIndex);

            this.isPlayerNumberInRange(characterNumber);

            int intNumber = characterNumber - '0';
            if (this.playerGuessNumberList.contains(intNumber)){
                throw new IllegalArgumentException();
            }
            this.playerGuessNumberList.add(intNumber);

        }
    }
    private void isPlayerNumberInRange(char playerGuessNumber){

        if (playerGuessNumber < GameSettings.MIN_INPUT_CHARACTER || playerGuessNumber > GameSettings.MAX_INPUT_CHARACTER){
            throw new IllegalArgumentException();
        }
    }

    public Iterator<Integer> getHandledResult(){
        return this.playerGuessNumberList.iterator();
    }
}
