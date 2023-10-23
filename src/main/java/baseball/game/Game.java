package baseball.game;

import baseball.checker.BaseBallChecker;
import baseball.factory.NumberFactory;
import camp.nextstep.edu.missionutils.Console;

import static baseball.checker.InputValueChecker.*;
import static baseball.message.GameDefaultMessage.*;
import static baseball.message.GameResultMessage.*;

// 게임 진행을 위한 클래스
public class Game {
    public static void startGame() {
        System.out.println(GAME_START.getMessage());

        String inputValue;
        String targetNumber = NumberFactory.getRandomNumber();
        System.out.println(targetNumber);

        while(true) {
            inputValue = Console.readLine();
            checkNumberValidation(inputValue);

            int resultCode = BaseBallChecker.checkGameResult(inputValue, targetNumber);

            System.out.println(getMessageByCode(resultCode));

            if(resultCode != STRIKE_3.getCode()) continue;

            System.out.println(GAME_END.getMessage());
            System.out.println(INPUT_SIGNAL.getMessage());

            String userSignal = Console.readLine();
            checkSignalValidation(userSignal);

            if(userSignal.equals("2")) break; // 사용자가 2를 입력할 경우, 게임 종료

            targetNumber = NumberFactory.getRandomNumber();
        }

        Console.close();
    }
}