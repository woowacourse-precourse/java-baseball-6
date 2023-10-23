package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
public class Computer {
    private static final int SIZE = 3;
    private static boolean[][] baseballFlag = new boolean[3][3];
    private static int[] numbers = new int[SIZE];
    public Computer() {
        int randomNumber;
        for (int i = 0; i < SIZE; i++){
            randomNumber = Randoms.pickNumberInRange(1, 9);
            // numbers Array에 숫자 중복 체크해야함. -> checkDup
            if (!checkDup(numbers, randomNumber))
                numbers[i] = randomNumber;
        }
    }
    private boolean checkDup(int[] numberOfArr, int randomNumber){
        //Make Code About check duplication.
        for (int number : numberOfArr){
            if (randomNumber == number)
                return true;
        }
        return false;
    }
}
