package baseball;

import baseball.AnswerGenerator;
import baseball.FeedbackAssistant;

public class BaseballGame {
    private final FeedbackAssistant feedbackAssistant;
    private static String answer;

    BaseballGame() {
        feedbackAssistant = new FeedbackAssistant();
    }

    public void startGame() {
        feedbackAssistant.printStartMessage();
        this.runGame();
    }

    private void generateAnswer(){
        AnswerGenerator answerGenerator = new AnswerGenerator();

        this.answer = answerGenerator.generateAnswer();
    }

    public void runGame() throws IllegalArgumentException {
        this.generateAnswer();
        while (true){
            if (this.evaluator.evaluateUserInput(this.answer) == true)
                break;
            else
                continue;
        }
    }
}
