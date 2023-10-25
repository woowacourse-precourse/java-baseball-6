package baseball;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String getInput() {
        return Console.readLine();
    }
    public int[] validateAndParseInput(String input) {
        Validator.validateInput(input);
        int[] guess = new int[3];
        for (int i = 0; i < 3; i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            guess[i] = digit;
        }
        return guess;
    }
}
