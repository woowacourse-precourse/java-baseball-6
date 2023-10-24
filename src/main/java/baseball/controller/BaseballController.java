package baseball.controller;

import baseball.GameSettings;
import baseball.model.AttemptResult;
import baseball.model.BaseballModel;
import baseball.view.BaseballView;
import java.util.Iterator;

public class BaseballController {
    private BaseballView view;
    private BaseballModel model;
    private PlayerInputHandler<Iterator<Integer>> playerGuessHandler;
    private PlayerInputHandler<RoundEndAction> roundEndActionHandler;

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
                } else if (roundEndAction == RoundEndAction.CONTINUE){
                    model.restart();
                }
            }

        }
    }

    private boolean isThreeStrike(AttemptResult attemptResult){
        return attemptResult.getStrikeCount() == GameSettings.NUM_DIGITS;
    }
}
