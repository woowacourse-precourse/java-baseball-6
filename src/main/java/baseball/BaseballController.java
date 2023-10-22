package baseball;

import java.util.Iterator;
public class BaseballController {
    private BaseballView view;
    private BaseballModel model;
    private PlayerInputHandler<Iterator<Integer>> playerGuessHandler;
    private PlayerInputHandler<RoundEndAction> roundEndActionHandler;

    public static final int NUMBER_OF_DIGITS = 3;
    public static final char MIN_INPUT_CHARACTER = '1';
    public static final char MAX_INPUT_CHARACTER = '9';

    public BaseballController(BaseballView view, BaseballModel model){
        this.view = view;
        this.model = model;
        this.playerGuessHandler = new PlayerGuessHandler();
        this.roundEndActionHandler = new RoundEndActionHandler();
    }

    public void play(){
        view.displayStartMessage();


        while(true){
            String playerGuess = view.getPlayerGuess();
            playerGuessHandler.handle(playerGuess);
            Iterator<Integer> guessNumberListIterator = playerGuessHandler.getHandledResult();

            AttemptResult attemptResult = model.getAttemptResult(guessNumberListIterator);

            view.displayAttemptResult(attemptResult.toString());

            if (isThreeStrike(attemptResult)){
                view.displayRoundEndMessage();
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

    private boolean isThreeStrike(AttemptResult attemptResult){
        return attemptResult.getStrikeCount() == NUMBER_OF_DIGITS;
    }
}
