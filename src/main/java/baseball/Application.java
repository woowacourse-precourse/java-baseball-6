package baseball;

import baseball.controller.GameController;
import baseball.model.NumberFormat;
import baseball.model.UserAction;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.controller.GameController.*;
import static baseball.model.NumberFormat.createNumberFormat;
import static baseball.model.NumberFormat.generateRandomNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        boolean continueMode = true;
        boolean isFinished;

        printInitMessage();
        try {
            while (continueMode) {
                isFinished = false;
                gameController.setComputerNumber(generateRandomNumber());
                while (!isFinished){
                    System.out.print("숫자를 입력하세요 : ");
                    Integer userNumber = Integer.valueOf(Console.readLine());
                    gameController.setUserNumber(createNumberFormat(userNumber));
                    if (gameController.checkGameResult()) isFinished = true;
                    System.out.println();
                }


                printEndMessage();
                UserAction userAction = UserAction.valueOf(Integer.valueOf(Console.readLine()));
                if (userAction == UserAction.FINISH) continueMode = false;
            }

        } catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException();
        }


    }
}
