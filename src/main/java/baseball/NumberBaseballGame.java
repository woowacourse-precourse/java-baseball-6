package baseball;

import java.util.List;

public class NumberBaseballGame {
    Message message = new Message();
    Computer computer = new Computer();
    InputValidation inputValidation = new InputValidation();
    UserInput userInput = new UserInput();

    public void speaker(String message) {
        System.out.print(message);
    }

    public void play() {
        boolean gameStatus = true;
        while (gameStatus) {
            speaker(message.startMessage() + '\n');
            oneRound();
            speaker(message.restartOrStopMessage());
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
            speaker(message.requestNumberMessage());
            String userLine = userInput.getUserInput();
            List<Integer> userNumbers = inputValidation.validateUserNumbers(userLine);
            List<Integer> answer = answerMaker.getAnswer();
            List<Integer> ballAndStrikeCount = computer.countScore(answer, userNumbers);
            int strikeCount = ballAndStrikeCount.get(1);

            speaker(message.scoreMessage(ballAndStrikeCount) + '\n');
            if (strikeCount == 3) {
                threeStrike = true;
            }
        }
        speaker(message.successMessage() + '\n');
    }
}
