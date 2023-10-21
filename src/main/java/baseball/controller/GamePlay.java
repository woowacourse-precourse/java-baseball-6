package baseball.controller;

import baseball.util.Array;
import baseball.util.ThrowError;
import baseball.view.Input;
import java.util.Arrays;


public class GamePlay {
    public static void playing () {
        int[] randomNumbers = Array.makeRandom();
        boolean validationResult = true;
        while(validationResult) {
            String inputValue = Input.printNoticeInputNum();
            ThrowError.throwError(inputValue);
            int[] inputNumbers = Array.strToArr(inputValue);
        }
    }
}
