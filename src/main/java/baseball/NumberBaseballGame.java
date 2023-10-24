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
            System.out.println(START_MESSAGE);
            makeAnswer();
            oneRound();
            gameStatus = restartOrStop();
        }
    }

    private boolean restartOrStop() {
        System.out.print(RESTART_OR_STOP_MESSAGE);
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
        System.out.println(SUCCESS_MESSAGE);
    }

    private int scoreResult() {
        System.out.print(REQUEST_NUMBER_MESSAGE);
        List<Integer> answer = answerMaker.getAnswer();
        List<Integer> scoreBoard = scoreCounter.countScore(answer, userAnswer());
        System.out.println(message.scoreMessage(scoreBoard));
        int strikeCount = scoreBoard.get(1);

        return (strikeCount);
    }

    //유저의 정보를 입력받고 validation -> 리스트 반환
    private List<Integer> userAnswer() {
        String input = getUserInput();

        return (inputValidation.validateAndConvertUserNumbers(input));
    }

    //클래스 내부에 정답 생성
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
