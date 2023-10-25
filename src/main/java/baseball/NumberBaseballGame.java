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


    public void play() {
        boolean gameStatus = true;

        while (gameStatus) {
            speaker(START_MESSAGE + '\n');
            answerMaker.makeAnswer(1, 9);
            oneRound();
            gameStatus = restartOrStop();
        }
    }

    private void oneRound() {
        boolean threeStrike = false;

        while (!threeStrike) {
            speaker(REQUEST_NUMBER_MESSAGE);
            int strikeCount = scoreResult();

            threeStrike = isThreeStrike(strikeCount);
        }
        speaker(SUCCESS_MESSAGE + '\n');
    }

    public void speaker(String message) {
        System.out.print(message);
    }

    private boolean restartOrStop() {
        System.out.println(RESTART_OR_STOP_MESSAGE);
        String sign = getUserInput();

        inputValidation.validateRestartOrStop(sign);
        return sign.charAt(0) != '2';
    }

    private int scoreResult() {
        List<Integer> answer = answerMaker.getAnswer();
        List<Integer> scoreBoard = scoreCounter.countScore(answer, userAnswer());
        speaker(message.scoreMessage(scoreBoard) + '\n');

        return scoreBoard.get(1);
    }

    //유저의 정보를 입력받고 validation -> 리스트 반환
    private List<Integer> userAnswer() {
        String input = getUserInput();

        return (inputValidation.validateAndConvertUserNumbers(input));
    }

    private boolean isThreeStrike(int strike) {
        return (strike == 3);
    }

    private String getUserInput() {
        return (Console.readLine());
    }
}
