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
            AnswerMaker answerMaker = new AnswerMaker(1, 9); // 각 라운드당 하나의 정답을 생성하기
            System.out.println("answer ?" + answerMaker.getAnswer());
            oneRound(answerMaker.getAnswer());
            speaker(message.restartOrStopMessage());
            gameStatus = restartOrStop();
        }
    }

    public boolean restartOrStop() {
        String sign = userInput.getUserInput();
        inputValidation.validateRestartOrStop(sign);
        return (sign.charAt(0) != '2');
    }

    public void oneRound(List<Integer> answer) {
        boolean threeStrike = false;
        while (!threeStrike) {
            speaker(message.requestNumberMessage());
            String userLine = userInput.getUserInput();
            List<Integer> userNumbers = inputValidation.convertStrToIntegerList(userLine);
            List<Integer> score = computer.countScore(answer, userNumbers);
            speaker(message.scoreMessage(score) + '\n');
            if (score.get(1) == 3) {
                threeStrike = true;
            }
        }
        speaker(message.successMessage() + '\n');
    }
}
