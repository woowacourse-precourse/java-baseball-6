package baseball;

import java.util.List;

public class BaseballGame {

    private final AnswerGenerator answerGenerator = new AnswerGenerator();

    private final GuessInputConverter guessInputConverter = new GuessInputConverter();

    private final StopInputConverter stopInputConverter = new StopInputConverter();

    private Judgment judgment;

    public void start() {
        boolean stop = false;
        while (!stop) {
            prepare();
            repeatedGuess();
            stop = isStop();
        }
    }

    private void prepare() {
        OutMessage.START.printMsg();
        judgment = new Judgment(answerGenerator.generate());
    }

    private void repeatedGuess() {
        boolean success = false;
        while (!success) {
            success = guessAndJudge();
        }
        OutMessage.ANSWER.printMsg();
    }

    private boolean guessAndJudge() {
        final List<Integer> guess = guessInputConverter.getValue();
        return judgment.judge(guess);
    }

    private boolean isStop() {
        return stopInputConverter.getValue() == 2;
    }

}