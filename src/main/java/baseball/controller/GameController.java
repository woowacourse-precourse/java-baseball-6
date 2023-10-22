package baseball.controller;

import baseball.core.CheckGameResult;
import baseball.core.CompareNumber;
import baseball.core.GenerateNumberList;
import baseball.property.GameCondition;
import baseball.property.GameScore;
import baseball.validation.GameValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    public static void playingBaseballGame(GameCondition game_coin){
        List<Integer> computer = GenerateNumberList.generateRandomNumberToComputer(3);
        while (game_coin.equals(GameCondition.CONTINUE)){
            OutputView.outputForGameValueInput();
            String user_input_value = InputView.readLineByConsole();
            if (GameValidation.verifyForGameValue(user_input_value)){
                List<Integer> user = GenerateNumberList.generateInputValueToUser(user_input_value);
                GameScore gameScore = CompareNumber.compareNumberList(user, computer);
                game_coin = CheckGameResult.checkGameScore(gameScore, game_coin);
            }
        }
        OutputView.outputForRetryCondition();
    }
}
