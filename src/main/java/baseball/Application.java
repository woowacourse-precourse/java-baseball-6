package baseball;

import static others.ExceptionHandling.digitsExceptionTesting;
import static others.Others.getNumber;
import static others.Others.ifRestart;
import static others.Others.printGameStart;
import static others.Value.compareDigits;
import static others.Value.computerGenerateNum;
import static others.Value.playerGenerateNum;
import static others.Value.printResult;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printGameStart();
        boolean ifGameContinue = true;
        while (ifGameContinue) {
            List<Integer> computerNum = computerGenerateNum();
            boolean guess = false;
            while (!guess) {
                String getStrNumber = getNumber();
                digitsExceptionTesting(getStrNumber);
                List<Integer> playerNum = playerGenerateNum(getStrNumber);
                compareDigits(computerNum, playerNum);
                guess = printResult();
                if (guess) {
                    ifGameContinue = ifRestart();
                }
            }
        }
    }
}