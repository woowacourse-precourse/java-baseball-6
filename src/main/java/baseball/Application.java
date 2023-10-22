package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            BaseBall baseBall = new BaseBall();
            baseBall.run();

            String inputNumber = Console.readLine();
            TerminateNumber terminateNumber = new TerminateNumber(inputNumber);
            if (terminateNumber.isTerminate()) {
                break;
            }
        }
    }
}
