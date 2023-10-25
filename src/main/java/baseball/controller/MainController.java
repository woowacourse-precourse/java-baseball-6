package baseball.controller;

import baseball.model.Number;
import baseball.model.Result;
import baseball.model.ResultCase;
import baseball.view.View;

public class MainController {
    private final View view;
    private final InteractionController interactionController;
    private final BusinessController businessController;

    public MainController(View view, InteractionController interactionController, BusinessController businessController) {
        this.view = view;
        this.interactionController = interactionController;
        this.businessController = businessController;
    }

    public void startGame() {
        view.showStartLine();
        boolean isAnswer = false;
        Number computerNumber = businessController.generateComputerNumber();
        while (!isAnswer) {
            view.showInputLine();
            Number userNumber = businessController.generateUserNumber();
            Result result = businessController.compareUserNumberAndComputerNumber(userNumber, computerNumber);
            isAnswer = calculateResult(isAnswer, result);
        }
        view.showEndLine();
        if (interactionController.readChoiceData() == 1) {
            startGame();
        }
    }

    private boolean calculateResult(boolean isAnswer, Result result) {
        ResultCase resultCase = result.getResultCase();
        switch (resultCase) {
            case CORRECT -> {
                view.showCorrectLine();
                isAnswer = true;
            }
            case PARTIAL_MISMATCH -> view.showPartialMismatchLine(result);
            case ALL_MISMATCH -> view.showAllMismatchLine();
        }
        return isAnswer;
    }
}
