package baseball.application.service;

import baseball.constants.ErrorConst;
import baseball.domain.entity.Answer;
import baseball.domain.entity.Hint;
import baseball.domain.entity.Prediction;
import baseball.domain.service.HintCreateService;
import baseball.domain.service.PredictionCreateService;

public class GameFacade {
    private final HintCreateService hintCreateService;
    private final PredictionCreateService predictionCreateService;

    private Answer answer;

    public GameFacade(HintCreateService hintCreateService, PredictionCreateService predictionCreateService) {
        this.hintCreateService = hintCreateService;
        this.predictionCreateService = predictionCreateService;
    }

    public void startGame() {
        this.answer = new Answer();
    }

    public void continueGame(final String input) {
        if (input.equals("1")) {
            restartGame();
        } else if (input.equals("2")) {
            endGame();
        } else {
            throw new IllegalArgumentException(ErrorConst.INVALID_INPUT.getMessage());
        }
    }

    public boolean progressing() {
        return this.answer == null;
    }

    public Hint generateHint(final String input) {
        final Prediction prediction = createPrediction(input);

        return hintCreateService.createHintFromAnswerNumbersAndInputNumbers(answer.getNumberList(), prediction.numberList());
    }

    private void restartGame() {
        this.answer.resetAnswer();
    }

    private void endGame() {
        this.answer = null;
    }

    private Prediction createPrediction(final String input) {
        return predictionCreateService.createPrediction(input);
    }
}
