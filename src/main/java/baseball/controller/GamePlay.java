package baseball.controller;

import baseball.util.Array;
import baseball.util.ThrowError;
import baseball.view.Input;
import baseball.view.Output;
import java.util.Arrays;


public class GamePlay {
    public static void playing () {
        int[] randomNumbers = Array.makeRandom();
        boolean validationResult = true;
        while(validationResult) {
            String inputValue = Input.printNoticeInputNum();
            ThrowError.throwError(inputValue);
            int[] inputNumbers = Array.strToArr(inputValue);
            int[] compareResult = Array.checkNumbers(randomNumbers, inputNumbers);
            printResult(compareResult);
            if(compareResult[0] == 3) {
                validationResult = false;
            }
        }
    }

    public static void printResult (int[] compareResult) {
        if(compareResult[0] != 0 && compareResult[1] != 0) {
            Output.printBall(compareResult[0]);
            Output.printStrike(compareResult[1]);
        } else if (compareResult[0] != 0) {
            Output.printBall(compareResult[0]);
            System.out.println();
        } else if (compareResult[1] != 0) {
            Output.printStrike(compareResult[1]);
            System.out.println();
        } else {
            Output.printWhenGameEnd();
        }
    }


}
