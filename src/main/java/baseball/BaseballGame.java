package baseball;

import baseball.AnswerGenerator;
import baseball.FeedbackAssistant;

public class BaseballGame {
//    private final FeedbackAssistant feedbackAssistant;
    private final Evaluator evaluator;
    private static String answer;

    BaseballGame() {
//        feedbackAssistant = new FeedbackAssistant();
        evaluator = new Evaluator();
    }

    public void startGame() {
        FeedbackAssistant.printStartMessage();
        this.runGame();
    }

    private void generateAnswer(){
        AnswerGenerator answerGenerator = new AnswerGenerator();

        answer = answerGenerator.generateAnswer();
    }

    public void runGame() throws IllegalArgumentException {
        this.generateAnswer();
        while (true){
            if (this.evaluator.evaluateUserInput(answer))
                break;
            else
                continue;
        }
    }
}
