package baseball;

import java.util.List;

public class NumberBaseballGame {
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
            AnswerMaker answerMaker = new AnswerMaker(1, 9); // 각 라운드당 하나의 정답을 생성하기
            System.out.println("answer ?" + answerMaker.getAnswer());
            oneRound(answerMaker.getAnswer());
            speaker(message.restartOrStopMessage());
            gameStatus = restartOrStop();
        }
    }

    public boolean restartOrStop() {
        String sign = userInput.getUserInput();
        userInput.validateContinueSign(sign);
        return (sign.charAt(0) != '2');
    }

    public void oneRound(List<Integer> answer) {
        boolean threeStrike = false;
        while (!threeStrike) {
            speaker(message.requestNumberMessage());
            List<Integer> userNumbers = userInput.makeUserInputToThreeNumbers();
            List<Integer> score = computer.countScore(answer, userNumbers);
            speaker(message.scoreMessage(score) + '\n');
            if (score.get(1) == 3) {
                threeStrike = true;
            }
        }
        speaker(message.successMessage() + '\n');
    }
}
