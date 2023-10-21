package baseball.utils;

import baseball.view.UserInPut;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class GameUtil {
    public boolean validateExistNumber(int[] gameRandomNumber, int randomNumber) {
        for (int number : gameRandomNumber) {
            if (number == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
