package baseball;

import baseball.AnswerGenerator;
import baseball.Evaluator;
import baseball.FeedbackAssistant;

//import

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

    private void runGame(){
        this.generateAnswer();
        feedbackAssistant.printString(this.answer);
//        while (endOfGame != true){
//            try = this.evaluator.사용자 입력 받기(validate)
//            try ==
//        }
//        evaluator -> 게임 재시작 or 종료 입력 받음
//        종료시 리턴, 재시작시 runGame 호출(재귀)
    }

}
