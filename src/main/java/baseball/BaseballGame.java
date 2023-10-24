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

    private void runGame() throws IllegalArgumentException {
        this.generateAnswer();
        feedbackAssistant.printString(this.answer);
//        String tryInput = "";
//        while (endOfGame != true){
            this.evaluator.evaluateUserInput();
//            this.feedbackAssistant.printString(tryInput);
//            this.evaluator.isValidInput(tryInput);
//            try ==
//        }
//        evaluator -> 게임 재시작 or 종료 입력 받음
//        종료시 리턴, 재시작시 runGame 호출(재귀) -> 재귀로 인해 스택 메모리 누적이
//        걱정 되긴 한다. 딱히 크게 저장하는 게 없으니 규모가 작은 게임(1억번 재시작 하는 사람은 없을거야..)
//        에선 괜찮을 거라 판단.
    }

}
