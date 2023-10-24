package baseball;

import baseball.AnswerGenerator;
import baseball.Evaluator;
import baseball.FeedbackAssistant;

public class BaseballGame {
    private final AnswerGenerator answerGenerator;
    private final Evaluator evaluator;
    private final FeedbackAssistant feedbackAssistant;
    private static String answer;

    private static Boolean endOfGame = false;
    private static Boolean endOfProgram = false;

    BaseballGame() {
        this.answerGenerator = new AnswerGenerator();
        this.evaluator = new Evaluator();
        this.feedbackAssistant = new FeedbackAssistant();
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
        while (endOfGame != true){
            if (this.evaluator.evaluateUserInput(this.answer) == true)
                break;
            else
                continue;
        }
    }
}
