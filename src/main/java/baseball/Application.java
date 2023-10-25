package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.InputProcessor.*;
import static baseball.OutputProcessor.*;

public class Application {

    public List<Integer> numbers;

    private void initializeNumber() {
        numbers = new ArrayList<>();
        while (numbers.size() != 3) {
            Integer number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public void run() {
        initializeNumber();
        printStartMessage();

        while (true) {
            printPitchInputMessage();
            String pitchInput = Console.readLine();

            validatePitchInput(pitchInput);
            Score score = ScoreCalculator.calculate(parsePitchInput(pitchInput), numbers);

            printScore(score);

            if (score.getStrike() == 3) {
                printCompleteMessage();
                String restartInput = Console.readLine();

                validateRestartInput(restartInput);

                if (restartInput.equals("2")) {
                    printExitMessage();
                    break;
                }

                initializeNumber();
            }
        }
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
