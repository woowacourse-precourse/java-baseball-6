package baseball;

import java.util.List;

public class Game {

    public Game() {
    }

    public void play() {
        Computer computer = new Computer();
        List<Integer> randomNumbers = computer.getRandomNumbers();

        boolean correctAnswer = false;

        do {
            int[] validInput = InputUI.getUserNumbers();

            correctAnswer = computer.isCorrectGuess(validInput);

            if (!correctAnswer) {
                Hint.provideHint(randomNumbers, validInput);
            }
        } while (!correctAnswer);
    }
}
