package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    public Game() {
    }

    public void play() {
        Computer computer = new Computer();
        List<Integer> randomNumbers = computer.getRandomNumbers();

        boolean correctAnswer = false;

        do {
            System.out.print("숫자를 입력해주세요 : ");

            String userInput = getUserInput();

            int[] validInput = InputValidator.validateAndParseUserInput(userInput);

            boolean isCorrect = computer.isCorrectGuess(validInput);
        } while (!correctAnswer);
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
