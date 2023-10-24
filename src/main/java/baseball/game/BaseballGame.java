package baseball.game;

import java.util.List;

public class BaseballGame {

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        Computer computer = new Computer();
        User user = new User();

        boolean correctAnswer = false;
        boolean restart = false;

        List<Integer> computerNumber = computer.createComputerNumber();
        while (true) {
            List<Integer> userNumber = user.createUserNumber();

            List<Integer> comparedResult = computer.compareEachNumber(computerNumber, userNumber);

            String resultMessage = computer.createResultMessage(comparedResult);
            System.out.println(resultMessage);

            correctAnswer = computer.checkAnswer(resultMessage);

            if (correctAnswer) {
                break;
            }
        }

        restart = computer.decideRestartOrExit();
        if (restart) {
            play();
        }
    }
}
