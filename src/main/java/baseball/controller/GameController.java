package baseball.controller;

import baseball.property.GameCondition;
import baseball.validation.GameValidation;
import baseball.view.InputView;

public class GameController {

    public static void playingBaseballGame(GameCondition game_coin){
        while (game_coin.equals(GameCondition.CONTINUE)){
            String user_input_value = InputView.readLineByConsole();
            if (GameValidation.verifyForGameValue(user_input_value)){
                System.out.println("검증된값!");
            }
        }
    }
}
