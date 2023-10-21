package baseball;

import static baseball.MessageConstant.REQUEST_NUMBER_MESSAGE;
import static baseball.MessageConstant.RESTART_OR_STOP_MESSAGE;
import static baseball.MessageConstant.START_MESSAGE;
import static baseball.MessageConstant.SUCCESS_MESSAGE;

import java.util.List;

public class NumberBaseballGame {
    MessageConstant messageConstant = new MessageConstant();
    Computer computer = new Computer();
    InputValidation inputValidation = new InputValidation();
    UserInput userInput = new UserInput();

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

        inputValidation.validateRestartOrStop(sign);
        return (sign.charAt(0) != '2');
    }

    private void oneRound() {
        AnswerMaker answerMaker = new AnswerMaker(1, 9);// 각 라운드당 하나의 정답을 생성하기
        boolean threeStrike = false;

        while (!threeStrike) {
            speaker(REQUEST_NUMBER_MESSAGE);
            String userLine = userInput.getUserInput();
            List<Integer> userNumbers = inputValidation.validateUserNumbers(userLine);
            List<Integer> answer = answerMaker.getAnswer();
            List<Integer> ballAndStrikeCount = computer.countScore(answer, userNumbers);
            int strikeCount = ballAndStrikeCount.get(1);

            speaker(messageConstant.scoreMessage(ballAndStrikeCount) + '\n');
            if (strikeCount == 3) {
                threeStrike = true;
            }
        }
        speaker(SUCCESS_MESSAGE + '\n');
    }
}
