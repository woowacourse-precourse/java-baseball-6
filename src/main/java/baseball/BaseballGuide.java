package baseball;

import User.Player;
import camp.nextstep.edu.missionutils.Console;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import Util.Printer;

public class BaseballGuide {

    public boolean isRestartCommand(String userGuess) {
        return "1".equals(userGuess);
    }

    public boolean isEndCommand(String userGuess) {
        return "2".equals(userGuess);
    }
    public int[] convertGuessToIntArray(int guess) {
        int[] guessDigits = new int[3];
        for (int i = 2; i >= 0; i--) {
            guessDigits[i] = guess % 10;
            guess /= 10;
        }
        return guessDigits;
    }
    public Player getPlayerInput() {
        String input = Console.readLine();
        return new Player(input);
    }

    public String constructResultString(BallCount ballCount) {
        return Stream.of(
                        ballCount.getBalls() > 0 ? Optional.of(ballCount.getBalls() + "볼") : Optional.<String>empty(),
                        ballCount.getStrikes() > 0 ? Optional.of(ballCount.getStrikes() + "스트라이크") : Optional.<String>empty()
                )
                .flatMap(Optional::stream)
                .collect(Collectors.joining(" "));
    }

    public boolean isNothing(BallCount ballCount) {
        return ballCount.getStrikes() == 0 && ballCount.getBalls() == 0;
    }

    public void displayResult(BallCount ballCount, Printer print) {
        if (isNothing(ballCount)) {
            print.print(Printer.Message.NOTHING);
            return;
        }
        String result = constructResultString(ballCount);
        System.out.println(result);
    }
}