package baseball;

import java.util.ArrayList;
import java.util.Iterator;
public class BaseballController {
    private BaseballView view;
    private BaseballModel model;

    private static final int NUMBER_OF_DIGITS = 3;
    private static final char MIN_INPUT_CHARACTER = '1';
    private static final char MAX_INPUT_CHARACTER = '9';
    private static final String CONTINUE_OPTION = "1";
    private static final String QUIT_OPTION = "2";

    public BaseballController(BaseballView view, BaseballModel model){
        this.view = view;
        this.model = model;
    }


    public void play(){
        this.view.displayStartMessage();

        while(true){
            String playerGuess = this.view.getPlayerGuess();
            Iterator<Integer> guessIterator = this.convertStringGuessToIterator(playerGuess);
            RoundResult roundResult = model.getRoundResult(guessIterator);

            view.displayResult(roundResult.toString());

            if (this.isThreeStrike(roundResult)){
                this.view.displayRoundEnd();
                String actionInput = view.getContinuity();
                GameAction action = this.getAction(actionInput);

                if (action == GameAction.QUIT){
                    break;
                }
                else if (action == GameAction.CONTINUE){
                    model.restart();
                }
            }

        }
    }

    private boolean isThreeStrike(RoundResult roundResult){
        return roundResult.getStrikeCount() == NUMBER_OF_DIGITS;
    }

    private GameAction getAction(String actionInput){
        if (actionInput.equals(CONTINUE_OPTION)){
            return GameAction.CONTINUE;
        }
        if (actionInput.equals(QUIT_OPTION)){
            return GameAction.QUIT;
        }
        throw new IllegalArgumentException();
    }
    private Iterator<Integer> convertStringGuessToIterator(String playerGuess){
        ArrayList<Integer> guessList =  new ArrayList<>();
        if (playerGuess.length() != NUMBER_OF_DIGITS){
            throw new IllegalArgumentException();
        }


        for (int playerGuessIndex = 0; playerGuessIndex < playerGuess.length(); playerGuessIndex++){
            char characterNumber = playerGuess.charAt(playerGuessIndex);

            if (this.isInputNumberInRange(characterNumber)){
                throw new IllegalArgumentException();
            }

            int intNumber = characterNumber - '0';
            if (guessList.contains(intNumber)){
                throw new IllegalArgumentException();
            }
            guessList.add(intNumber);

        }
        return guessList.iterator();
    }
    private boolean isInputNumberInRange(char inputNumber){

        if (inputNumber < MIN_INPUT_CHARACTER || inputNumber > MAX_INPUT_CHARACTER){
            throw new IllegalArgumentException();
        }
        return false;
    }
}
