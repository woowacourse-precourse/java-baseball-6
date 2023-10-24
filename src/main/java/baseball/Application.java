package baseball;

import baseball.controller.GameController;
import baseball.model.UserAction;
import camp.nextstep.edu.missionutils.Console;

import static baseball.controller.GameController.*;
import static baseball.model.NumberFormat.createNumberFormat;
import static baseball.model.NumberFormat.generateRandomNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        printInitMessage();

        do {
            playRound(gameController);
            printEndMessage();
        } while (isContinue());
    }

    private static void playRound(GameController gameController){
        boolean isFinished = false;
        gameController.setComputerNumber(generateRandomNumber());

        while (!isFinished){
            try {
                System.out.print("숫자를 입력하세요 : ");
                Integer userNumber = Integer.valueOf(Console.readLine());
                gameController.setUserNumber(createNumberFormat(userNumber));
                isFinished = gameController.checkIfRoundEnd();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isContinue() {
        try {
            UserAction userAction = UserAction.valueOf(Integer.valueOf(Console.readLine()));
            return userAction == UserAction.CONTINUE;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
