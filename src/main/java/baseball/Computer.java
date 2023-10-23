package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
public class Computer {
    private static final int SIZE = 3;
    int[] baseballFlag = {0, 0};
    int[] numbers = new int[SIZE];
    Computer() {
        int randomNumber;
        for (int i = 0; i < SIZE;){
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!isDup(numbers, randomNumber))
                numbers[i++] = randomNumber;
        }
    }
    public static boolean isDup(int[] numberOfArr, int randomNumber){
        //Make Code About check duplication.
        for (int number : numberOfArr){
            if (randomNumber == number)
                return true;
        }
        return false;
    }

    private static void checkResult(String userInput, Computer alice){
        int tempNumber;
        alice.baseballFlag[0] = 0;
        alice.baseballFlag[1] = 0;
        for (int i = 0; i < SIZE; i++){
            tempNumber = Integer.parseInt(userInput.charAt(i) + "");
            updateFlag(tempNumber, i, alice);
        }
    }

    private static void updateFlag(int userInput, int digit, Computer alice){
        for (int currentDigit = 0; currentDigit < SIZE; currentDigit++){
            if (digit == currentDigit && userInput == alice.numbers[currentDigit]) {
                alice.baseballFlag[0] += 1; // strike
                return;
            }
            if (digit != currentDigit && userInput == alice.numbers[currentDigit]) {
                alice.baseballFlag[1] += 1; // ball
                return;
            }
        }
    }
    public void getComputerNumber(){
        System.out.println("" + numbers[0] + numbers[1] + numbers[2]);
    }
    public static void gameStart(Computer alice){
        User coh = new User();
        String userInput = coh.getUserInput();
        checkResult(userInput, alice);
        Message.makeMessage(alice.baseballFlag);
        if (alice.baseballFlag[0] != SIZE){
            Computer.gameStart(alice);
            return;
        }
        Message.getSuccessMsg();
        Message.newGameMsg();
        if (User.newGameFlag() == 1){
            Computer newGame = new Computer();
            Computer.gameStart(newGame);
        }
    }
}
