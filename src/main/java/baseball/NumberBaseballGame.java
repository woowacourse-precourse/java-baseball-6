package baseball;

import static baseball.Message.REQUEST_NUMBER_MESSAGE;
import static baseball.Message.RESTART_OR_STOP_MESSAGE;
import static baseball.Message.START_MESSAGE;
import static baseball.Message.SUCCESS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class NumberBaseballGame {
    private Message message = new Message();
    private ScoreCounter scoreCounter = new ScoreCounter();
    private InputValidation inputValidation = new InputValidation();
    private AnswerMaker answerMaker = new AnswerMaker();

    public void speaker(String message) {
        System.out.print(message);
    }

    public void play() {
        boolean gameStatus = true;

        while (gameStatus) {
            speaker(START_MESSAGE + '\n');
            makeAnswer();
            oneRound();
            gameStatus = restartOrStop();
        }
    }

    private boolean restartOrStop() {
        speaker(RESTART_OR_STOP_MESSAGE);
        String sign = getUserInput();

        inputValidation.validateRestartOrStop(sign);
        return sign.charAt(0) != '2';
    }

    private void oneRound() {
        boolean threeStrike = false;

        while (!threeStrike) {
            int strikeCount = scoreResult();

            threeStrike = isThreeStrike(strikeCount);
        }
        speaker(SUCCESS_MESSAGE + '\n');
    }

    private int scoreResult() {
        speaker(REQUEST_NUMBER_MESSAGE);
        List<Integer> scoreBoard = ballAndStrike();
        speaker(message.scoreMessage(scoreBoard) + '\n');
        int strikeCount = scoreBoard.get(1);

        return (strikeCount);
    }

    private List<Integer> userAnswer() {
        String input = getUserInput();

        return (inputValidation.validateAndConvertUserNumbers(input));
    }

    private List<Integer> ballAndStrike() {
        return (scoreCounter.countScore(answerMaker.getAnswer(), userAnswer()));
    }

    private void makeAnswer() {
        answerMaker.makeAnswer(1, 9);
    }

    private boolean isThreeStrike(int strike) {
        return (strike == 3);
    }

    private String getUserInput() {
        return (Console.readLine());
    }
}
