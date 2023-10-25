package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private GameNumber guessedNumber;

    public GameNumber guess() {
        this.guessedNumber = loadInputToGameNumber();
        return guessedNumber;
    }

    private GameNumber loadInputToGameNumber() {
        printGuessMessage();
        String input = Console.readLine();
        return GameNumber.from(input);
    }

    private static void printGuessMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}
