package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import static baseball.checker.BaseBallChecker.*;
import static baseball.checker.InputValueChecker.*;
import static baseball.factory.NumberFactory.*;
import static baseball.message.GameDefaultMessage.*;
import static baseball.message.GameResultMessage.*;

// 게임 진행을 위한 클래스
public class Game {
    public static void startGame() {
        printGameStartMessage();

        String inputValue;
        String targetNumber = getRandomNumber();

        while(true) {
            printInputValueFromUserMessage();
            inputValue = Console.readLine();
            checkNumberValidation(inputValue);

            int resultCode = checkGameResult(inputValue, targetNumber);

            printGameResultMessage(resultCode);

            if(resultCode != getTargetCode()) continue;

            printGameEndMessage();
            printInputSignalFromUserMessage();

            String userSignal = Console.readLine();
            checkSignalValidation(userSignal);

            if(userSignal.equals("2")) break; // 사용자가 2를 입력할 경우, 게임 종료

            targetNumber = getRandomNumber();
        }

        Console.close();
    }

    private static void printGameStartMessage() {
        System.out.println(GAME_START.getMessage());
    }

    private static void printInputValueFromUserMessage() {
        System.out.print(INPUT_VALUE.getMessage());
    }

    private static void printGameResultMessage(int resultCode) {
        System.out.println(getMessageByCode(resultCode));
    }

    private static void printGameEndMessage() {
        System.out.println(GAME_END.getMessage());
    }

    private static void printInputSignalFromUserMessage() {
        System.out.println(INPUT_SIGNAL.getMessage());
    }
}