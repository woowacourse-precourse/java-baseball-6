package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager{

    Validator validator = new Validator();
    PrintManager printManager = new PrintManager();

    public List<Integer> getGuessNumbers() throws IllegalArgumentException{

        String inputValue = getInput();

        List<Integer> guessNumbers = new ArrayList<>();

        if (validator.validateGuessNumber(inputValue)) {

            char[] charGuessNumber = inputValue.toCharArray();

            for (char i : charGuessNumber) {
                guessNumbers.add(i - '0');
            }

            return guessNumbers;

        }

        printManager.printError();
        throw new IllegalArgumentException();

    }

    public int getRestart() {

        String inputValue = getInput();
        System.out.println("inputValue = " + inputValue);


        if (validator.validateRestart(inputValue)) {
            return Integer.parseInt(inputValue);
        }

        printManager.printError();
        throw new IllegalArgumentException();

    }

    private String getInput() {

        return Console.readLine();

    }

}
