package baseball.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;

public class User extends PlayerEntity {

    @Override
    public void setNumberList() throws IllegalArgumentException{
        System.out.print("\n숫자를 입력해주세요 : ");
        int inputNumber = Integer.parseInt(Console.readLine());

        // validate 3-digit
        if (inputNumber < 100 || inputNumber > 999) {
            throw new IllegalArgumentException();
        }

        numberList.clear();
        while (inputNumber > 0) {
            int extractedNumber = inputNumber % 10; // extract number from 1's up to 100's
            numberList.add(extractedNumber);
            inputNumber /= 10; // remove last digit
        }

        // reverse arrange list for correct order (above logic adds 1s digit first)
        Collections.reverse(numberList);
    }
}
