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
        boolean threeStrike = false;

        while (!threeStrike) {
            int strikeCount = scoreResult(answerMaker.getAnswer());

            threeStrike = checkThreeStrike(strikeCount);
        }
        speaker(SUCCESS_MESSAGE + '\n');
    }

    private int scoreResult(List<Integer> answer) {
        speaker(REQUEST_NUMBER_MESSAGE);
        List<Integer> ballAndStrike = scoreCounter.countScore(answer, userAnswer());
        speaker(message.scoreMessage(ballAndStrike) + '\n');
        int strikeCount = ballAndStrike.get(1);

        return (strikeCount);
    }

    private List<Integer> userAnswer() {
        String input = userInput.getUserInput();

        return (inputValidation.validateAndConvertUserNumbers(input));
    }

    private boolean checkThreeStrike(int strike) {
        return (strike == 3);
    }
}
