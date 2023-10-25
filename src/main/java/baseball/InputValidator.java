package baseball;

import java.util.stream.Stream;

public class InputValidator {

    public int[] StringToInt (String input) {

        int[] numbers = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();

        StrictLength(input);
        StrictNumber(input);
        StrictRange(numbers);

        return numbers;
    }

    public void StrictLength (String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void StrictNumber (String input) {
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2))
        {
            throw new IllegalArgumentException();
        }

    }

    public void StrictRange (int[] input) {
        for (int i=0;i<3;i++){
            if (input[i] <1) {
                throw new IllegalArgumentException();
            }
        }

    }



}
