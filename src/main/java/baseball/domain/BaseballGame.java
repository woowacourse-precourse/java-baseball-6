package baseball.domain;

import static baseball.constants.SystemMessage.GAME_CREATE_MESSAGE;

import java.util.List;

public class BaseballGame {

    private static Computer computer;
    private static User user;

    public BaseballGame() {
        printGameCreateMessage();
    }

    private static void printGameCreateMessage() {
        System.out.println(GAME_CREATE_MESSAGE);
    }

    public void play() {
        computer = new Computer();
        user = new User();

        boolean correctAnswer = false;
        boolean restart = false;

        List<Integer> computerNumber = computer.createComputerNumber();
        do {
            List<Integer> userNumber = user.createUserNumber();

            List<Integer> comparedResult = computer.compareEachNumber(computerNumber, userNumber);

            String resultMessage = computer.createResultMessage(comparedResult);
            System.out.println(resultMessage);

            correctAnswer = computer.checkAnswer(resultMessage);

        } while (!correctAnswer);

        restart = computer.decideRestartOrExit();
        if (restart) {
            play();
        }
    }
}
