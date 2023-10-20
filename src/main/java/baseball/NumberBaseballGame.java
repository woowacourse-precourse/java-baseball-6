package baseball;

import java.util.List;

public class NumberBaseballGame {
    AnswerMaker answerMaker = new AnswerMaker();
    Message message = new Message();
    UserInput userInput = new UserInput();
    Computer computer = new Computer();

    public void speaker(String message) {
        System.out.print(message);
    }

    public void play() {
        boolean gameStatus = true;
        while (gameStatus) {
            speaker(message.startMessage() + '\n');
            computer.setAnswer(answerMaker.makeThreeDifferentNumberList(1, 9)); // 정답 생성 후 컴퓨터에 저장
            oneRound();
            speaker(message.restartOrStopMessage());
            String startOrStop = userInput.getUserInput();
            userInput.validateContinueSign(startOrStop);
            if (startOrStop.charAt(0) == '2') {
                gameStatus = false;
            }
        }
    }

    public void oneRound() {
        boolean threeStrike = false;
        while (!threeStrike) {
            speaker(message.requestNumberMessage());
            List<Integer> userNumbers = userInput.makeUserInputToThreeNumbers();
            List<Integer> score = computer.countScore(userNumbers);
            speaker(message.scoreMessage(score) + '\n');
            if (score.get(1) == 3) {
                threeStrike = true;
            }
        }
        speaker(message.successMessage() + '\n');
    }
}
