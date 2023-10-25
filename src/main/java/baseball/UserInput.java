package baseball;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String getInput() {
        return Console.readLine();
    }

    public int[] validateAndParseInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }

        int[] guess = new int[3];
        for (int i = 0; i < 3; i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            if (digit < 1 || digit > 9) {
                throw new IllegalArgumentException("입력은 1-9 사이여야 합니다.");
            }
            guess[i] = digit;
        }

        if (hasDuplicates(guess)) {
            throw new IllegalArgumentException("입력에 중복된 숫자가 있습니다.");
        }

        return guess;
    }

    private boolean hasDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
