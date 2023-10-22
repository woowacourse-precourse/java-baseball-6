package baseball;

import static baseball.BaseballGameConstants.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        playBaseballGame();
    }

    private static void playBaseballGame() {
        System.out.println(GAME_START_MESSAGE);
        while (true) {
            List<Integer> uniqueRandomNumber =
                    UniqueRandomNumberGenerator.randomNumberList(START_NUMBER, END_NUMBER, COUNT);
            while (true) {
                System.out.print(INPUT);
                String inputNumber = Console.readLine();
                List<Integer> answer = ProcessUserInput.userAnswer(inputNumber);
                if (RandomNumberMatch.isNumberMatched(uniqueRandomNumber, answer)) {
                    break;
                }
            }
            System.out.println(GAME_OVER_MESSAGE);
            String number = Console.readLine();
            if (!isGameRestart(number)) {
                Console.close();
                break;
            }
        }
    }

    private static boolean isGameRestart(String number) {
        validate(number);
        return number.equals(GAME_RESTART);
    }

    private static void validate(String number) {
        if (!(GAME_RESTART.equals(number) || GAME_END.equals(number))) {
            throw new IllegalArgumentException();
        }
    }
}