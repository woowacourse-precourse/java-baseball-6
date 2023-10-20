package baseball.game;

import baseball.view.Console;

import java.util.List;
import java.util.stream.IntStream;


public class Computer {

    private static List<Integer> computerNumber;


    public Computer() {

    }

    public void createRandomNumber() {

        computerNumber = Console.input3DigitRandomNumber();

    }

    public String getNumber() {
        return computerNumber;
    }
}
