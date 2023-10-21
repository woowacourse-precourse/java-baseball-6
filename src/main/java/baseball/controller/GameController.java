package baseball.controller;

import baseball.core.GenerateNumberList;
import baseball.property.GameCondition;
import baseball.validation.GameValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    public static void playingBaseballGame(GameCondition game_coin){
        List<Integer> computer_numbers = GenerateNumberList.generateRandomNumberToComputer(3);
        while (game_coin.equals(GameCondition.CONTINUE)){
            OutputView.outputForGameValueInput();
            String user_input_value = InputView.readLineByConsole();
            if (GameValidation.verifyForGameValue(user_input_value)){
                List<Integer> integers = GenerateNumberList.generateInputValueToUser(user_input_value);

            }
        }
    }
}
