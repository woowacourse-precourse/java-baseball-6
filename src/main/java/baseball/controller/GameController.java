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
        playingByUserInput(game_coin,computerGameListByRandomGenerate());
    }
    private static void playingByUserInput(GameCondition game_coin,List<Integer> computer){
        while (game_coin.equals(GameCondition.CONTINUE)){
            OutputView.outputForGameValueInput();
            String user_input_value = userInput();
            if (GameValidation.verifyForGameValue(user_input_value,3)){
                List<Integer> user = GenerateNumberList.generateInputValueToUser(user_input_value);
                GameScore gameScore = CompareNumber.compareNumberList(user, computer);
                game_coin = CheckGameResult.checkGameScore(gameScore, game_coin);
            }
        }
        userSuccessGame();
    }

    private static void userWantRetryGame(String user_input_retry){
        if (user_input_retry.equals("1")){
            playingByUserInput(GameCondition.CONTINUE,computerGameListByRandomGenerate());
        }
    }

    private static void userSuccessGame(){
        OutputView.outputForRetryCondition();
        afterGameSuccess();
    }

    private static void afterGameSuccess(){
        String user_input_retry = userInput();
        if (GameValidation.verifyForRetryValue(user_input_retry,1)){
            userWantRetryGame(user_input_retry);
        }
    }

    private static List<Integer> computerGameListByRandomGenerate(){
        return GenerateNumberList.generateRandomNumberToComputer(3);
    }

    private static String userInput(){
        return InputView.readLineByConsole();
    }
}
