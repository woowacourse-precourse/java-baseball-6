package baseball;

import java.util.List;

public class BaseballGame {

    private final AnswerGenerator answerGenerator = new AnswerGenerator();

    private final GuessNumberFromUser guessNumberFromUser = new GuessNumberFromUser();

    private final StartNumberFromUser startNumberFromUser = new StartNumberFromUser();

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
        System.out.println(OutMessage.START.getMsg());
        judgment = new Judgment(answerGenerator.generateAnswer());
    }

    private void repeatedGuess() {
        boolean success = false;
        while (!success) {
            final List<Integer> guess = guessNumberFromUser.getValue(OutMessage.GUESS);
            success = judgment.judge(guess);
        }
        System.out.println(OutMessage.ANSWER.getMsg());
    }

    private boolean isStop() {
        final int start = startNumberFromUser.getValue(OutMessage.RESTART);
        return start == 2;
    }

}