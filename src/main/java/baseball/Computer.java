package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
public class Computer {
    private static final int SIZE = 3;
    private final static int[] baseballFlag = {0, 0, 0};
    private final static int[] numbers = new int[SIZE];
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

    private void checkResult(String userInput){
        int tempNumber;
        for (int i = 0; i < SIZE; i++){
            tempNumber = Integer.parseInt(userInput.charAt(i) + "");
            updateFlag(tempNumber, i);
        }
    }

    private void updateFlag(int userInput, int digit){
        for (int currentDigit = 0; currentDigit < SIZE; currentDigit++){
            if (digit == currentDigit && userInput == numbers[currentDigit]) {
                baseballFlag[0] += 1; // strike
                return;
            }
            if (digit != currentDigit && userInput == numbers[currentDigit]) {
                baseballFlag[1] += 1; // ball
                return;
            }
            if (currentDigit == SIZE - 1)
                baseballFlag[2] += 1; // nothing
        }
    }
}
