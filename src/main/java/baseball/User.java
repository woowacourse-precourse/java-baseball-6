package baseball;

import camp.nextstep.edu.missionutils.Console;
import static baseball.Constants.*;
import static baseball.Utils.*;

public class User {
    private int[] numbers;

    public User() {
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void inputNumbers(){
        int[] numbers = new int[3];

        do {
            System.out.print(ENTER_NUMBERS);
            String userInput = Console.readLine();

            if (userInput.length() != 3)
                throw new IllegalArgumentException(ONLY_THREE_NUMBERS);

            for (int i = 0; i < 3; i++) {
                if (!(userInput.charAt(i) > '0' || userInput.charAt(i) <= '9'))
                    throw new IllegalArgumentException(ONLY_NUMBER_ALLOWED);
            }

            for (int i = 0; i < 3; i++) {
                numbers[i] = userInput.charAt(i) - '0';
            }

        }while (isDuplication(numbers));

        this.numbers = numbers;
    }
}
