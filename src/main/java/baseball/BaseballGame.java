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
        judgment = new Judgment(answerGenerator.generateAnswer());
    }

    private void repeatedGuess() {
        boolean success = false;
        while (!success) {
            final List<Integer> guess = guessInputConverter.getValue();
            success = judgment.judge(guess);
        }
        OutMessage.ANSWER.printMsg();
    }

    private boolean isStop() {
        return stopInputConverter.getValue() == 2;
    }

}