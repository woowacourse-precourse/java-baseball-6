package baseball.util;

import static baseball.constant.Constant.NUMBER_BASEBALL_STR_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;

public class RandomNumberUtil {
    public static char[] getThreeRandomNumbers() {

        char[] computerChar = new char[NUMBER_BASEBALL_STR_LENGTH];
        for (int i = 0; i < computerChar.length; i++) {
            while (computerChar[i] == 0) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!containNumberInCharArr(i, randomNumber, computerChar)) {
                    computerChar[i] = Character.forDigit(randomNumber, 10);
                }
            }
        }

        return computerChar;
    }

    private static boolean containNumberInCharArr(int i, int randomNumber, char[] computer) {

        return IntStream.range(0, i)
                .mapToObj(j -> computer[j] == randomNumber - '0')
                .anyMatch(Boolean::booleanValue);
    }
}
