package baseball;

import static baseball.others.Computer.computerGenerateNum;
import static baseball.others.ExceptionHandling.digitsExceptionTesting;
import static baseball.others.Output.printGameStart;
import static baseball.others.Output.printInputNumber;
import static baseball.others.Output.printRestart;
import static baseball.others.Player.playerGenerateNum;
import static baseball.others.Player.playerInputNumber;
import static baseball.others.ProgramController.compareDigits;
import static baseball.others.ProgramController.ifRestart;
import static baseball.others.ProgramController.resultJudgment;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    private static boolean ifGameContinue;
    private static boolean guess;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printGameStart();
        do {
            resetSetting();
            List<Integer> computerNum = computerGenerateNum();
            while (!guess) {
                printInputNumber();
                String guessingNumber = playerInputNumber();
                digitsExceptionTesting(guessingNumber);
                List<Integer> playerNum = playerGenerateNum(guessingNumber);
                compareDigits(computerNum, playerNum);
                guess = resultJudgment();
            }
            printRestart();
            String restartNumber = playerInputNumber();
            ifGameContinue = ifRestart(restartNumber);
        } while (ifGameContinue);
        Console.close();
        System.out.println("프로그램을 종료합니다.");
    }

    private static void resetSetting() {
        ifGameContinue = true;
        guess = false;
    }
}