package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean endFlag;
        printHandler.gameStartPrint();

        do {
            Computer computer = new Computer();
            InputHandler inputHandler = new InputHandler();

            while (true) {
                List<Integer> inputNumberList = inputHandler.inputNumber();

                if (computer.compareNumber(inputNumberList)) {
                    printHandler.gameEndPrint();
                    printHandler.choiceEndOrRePrint();
                    endFlag = inputHandler.choiceEndOrReInput();
                    break;
                }
            }
        } while (!endFlag);

       printHandler.programEnd();
    }
}
