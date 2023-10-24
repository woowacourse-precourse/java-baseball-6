package baseball;

import static baseball.Message.REQUEST_NUMBER_MESSAGE;
import static baseball.Message.RESTART_OR_STOP_MESSAGE;
import static baseball.Message.START_MESSAGE;
import static baseball.Message.SUCCESS_MESSAGE;

import java.util.List;

public class NumberBaseballGame {
    private Message message = new Message();
    private ScoreCounter scoreCounter = new ScoreCounter();
    private InputValidation inputValidation = new InputValidation();
    private UserInput userInput = new UserInput();
    private final String STOP_SIGN = "2";
    private final int MIN = 1;
    private final int MAX = 9;

    public void speaker(String message) {
        System.out.print(message);
    }

    public void play() {
        boolean gameStatus = true;

        while (gameStatus) {
            speaker(START_MESSAGE + '\n');
            oneRound();
            speaker(RESTART_OR_STOP_MESSAGE);
            gameStatus = restartOrStop();
        }
    }

    private boolean restartOrStop() {
        String sign = userInput.getUserInput();
        System.out.println("sign" + sign);

        inputValidation.validateRestartOrStop(sign);
        return sign.compareTo(STOP_SIGN) < 0;
    }

    private void oneRound() {
        AnswerMaker answerMaker = new AnswerMaker(MIN, MAX);// 정답 생성

        while (true) {
            speaker(REQUEST_NUMBER_MESSAGE);
            List<Integer> userNumbers = inputValidation.validateAndConvertUserNumbers(userInput.getUserInput());
            List<Integer> ballAndStrikeCount = scoreCounter.countScore(answerMaker.getAnswer(), userNumbers);
            int strikeCount = ballAndStrikeCount.get(1);
            speaker(message.scoreMessage(ballAndStrikeCount) + '\n');

            if (strikeCount == 3) {
                break;
            }
        }
        speaker(SUCCESS_MESSAGE + '\n');
    }
}
