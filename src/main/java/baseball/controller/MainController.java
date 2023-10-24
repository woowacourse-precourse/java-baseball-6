package baseball.controller;

import baseball.model.Number;
import baseball.model.Result;
import baseball.model.ResultCase;
import baseball.view.View;

public class MainController {
    private final View view;
    private final InteractionController interactionController;
    private final BusinessController businessController;
    private Number userNumber;
    private Number computerNumber;

    public MainController(View view, InteractionController interactionController, BusinessController businessController) {
        this.view = view;
        this.interactionController = interactionController;
        this.businessController = businessController;
    }

    public void startBaseballGame() {
        view.showStartLine();
        boolean isAnswer = false;
        computerNumber = businessController.generateComputerNumber();
        while (!isAnswer) {
            view.showInputLine();
            userNumber = businessController.generateUserNumber();
            Result result = businessController.compareUserNumberAndComputerNumber(userNumber, computerNumber);
            ResultCase resultCase = result.getResultCase();
            switch (resultCase) {
                case CORRECT -> {
                    view.showResultByCorrectAnswer();
                    isAnswer = true;
                }
                case PARTIAL_MISMATCH -> view.showResultByPartialMismatchAnswer(result);
                case ALL_MISMATCH -> view.showResultByAllMismatchAnswer();
            }
        }
        view.showEndLine();
        Integer choiceData = interactionController.readChoiceData();
        if (choiceData == 1) {
            startBaseballGame();
        } else {
            // TODO System.exit 제거 예정입니다.
            System.exit(0);
        }
    }
}
