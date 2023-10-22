package baseball;

import java.util.ArrayList;
import java.util.Iterator;
public class BaseballController {
    private BaseballView view;
    private BaseballModel model;

    public static final int NUMBER_OF_DIGITS = 3;
    public static final char MIN_INPUT_CHARACTER = '1';
    public static final char MAX_INPUT_CHARACTER = '9';

    public BaseballController(BaseballView view, BaseballModel model){
        this.view = view;
        this.model = model;
    }


    public void play(){
        this.view.displayStartMessage();


        PlayerInputHandler<Iterator<Integer>> playerGuessHandler = new PlayerGuessHandler();
        PlayerInputHandler<RoundEndAction> roundEndActionHandler = new RoundEndActionHandler();
        while(true){
            String playerGuess = this.view.getPlayerGuess();
            playerGuessHandler.handle(playerGuess);
            Iterator<Integer> guessNumberListIterator = playerGuessHandler.getHandledResult();

            RoundResult roundResult = model.getRoundResult(guessNumberListIterator);

            view.displayResult(roundResult.toString());

            if (this.isThreeStrike(roundResult)){
                this.view.displayRoundEnd();
                String stringRoundEndAction = view.getRoundEndAction();

                roundEndActionHandler.handle(stringRoundEndAction);

                RoundEndAction roundEndAction = roundEndActionHandler.getHandledResult();

                if (roundEndAction == RoundEndAction.QUIT){
                    break;
                }
                else if (roundEndAction == RoundEndAction.CONTINUE){
                    model.restart();
                }
            }

        }
    }

    private boolean isThreeStrike(RoundResult roundResult){
        return roundResult.getStrikeCount() == NUMBER_OF_DIGITS;
    }


//    private Iterator<Integer> convertStringGuessToIterator(String playerGuess){
//        ArrayList<Integer> guessList =  new ArrayList<>();
//        if (playerGuess.length() != NUMBER_OF_DIGITS){
//            throw new IllegalArgumentException();
//        }
//
//
//        for (int playerGuessIndex = 0; playerGuessIndex < playerGuess.length(); playerGuessIndex++){
//            char characterNumber = playerGuess.charAt(playerGuessIndex);
//
//            if (this.isInputNumberInRange(characterNumber)){
//                throw new IllegalArgumentException();
//            }
//
//            int intNumber = characterNumber - '0';
//            if (guessList.contains(intNumber)){
//                throw new IllegalArgumentException();
//            }
//            guessList.add(intNumber);
//
//        }
//        return guessList.iterator();
//    }
//    private boolean isInputNumberInRange(char inputNumber){
//
//        if (inputNumber < MIN_INPUT_CHARACTER || inputNumber > MAX_INPUT_CHARACTER){
//            throw new IllegalArgumentException();
//        }
//        return false;
//    }

    private RoundEndAction getRoundEndAction(String actionInput){
        if (actionInput.equals(RoundEndAction.CONTINUE.getValue())){
            return RoundEndAction.CONTINUE;
        }
        if (actionInput.equals(RoundEndAction.QUIT.getValue())){
            return RoundEndAction.QUIT;
        }
        throw new IllegalArgumentException();
    }

}
