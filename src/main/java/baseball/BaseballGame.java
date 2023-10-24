package baseball;

import java.util.List;

public class BaseballGame {

    private final AnswerGenerator answerGenerator = new AnswerGenerator();

    private final GuessNumberFromUser guessNumberFromUser = new GuessNumberFromUser();

    private final StartNumberFromUser startNumberFromUser = new StartNumberFromUser();

    private Judgment judgment;

    public void start() {
        System.out.println(OutMessage.START.getMsg());
        judgment = new Judgment(answerGenerator.generateAnswer());
        while (true) {
            final List<Integer> guess = guessNumberFromUser.getValue(OutMessage.GUESS);
            final boolean isAnswer = judgment.judge(guess);
            if (!isAnswer) {
                continue;
            }

            System.out.println(OutMessage.ANSWER.getMsg());

            final int restart = startNumberFromUser.getValue(OutMessage.RESTART);
            final boolean isRestart = (restart == 1);
            if (isRestart) {
                judgment = new Judgment(answerGenerator.generateAnswer());
                continue;
            }

            break;
        }
    }

}