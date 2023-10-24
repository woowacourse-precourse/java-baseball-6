package baseball.controller;

import baseball.domain.GameNumber;
import baseball.view.InputView;

public class InputNumberController {
    private static final String GAME_RETRY_ANSWER = "1";
    private static final String GAME_END_ANSWER = "2";
    InputView inputView = new InputView();

    public GameNumber guessNumber(){
        String inputNumber = inputView.inputNumber();

        if(!isNumericString(inputNumber)){
            throw new IllegalArgumentException();
        }
        return convertStringToGameNumber(inputNumber);
    }
    
    private boolean isNumericString(String inputNumber){
        return inputNumber.matches("[1-9]+");
    }

    private GameNumber convertStringToGameNumber(String inputNumber){
        GameNumber gameNumber = new GameNumber();

        String[] numStrings = inputNumber.split("");
        for(String numString : numStrings){
            int num = Integer.parseInt(numString);
            gameNumber.add(num);
        }

        return gameNumber;
    }


    public boolean retryNumber(){
        String retryNumber = inputView.retryNumber();

        if(retryNumber.equals(GAME_RETRY_ANSWER)){
            return true;
        }else if(retryNumber.equals(GAME_END_ANSWER)){
            return false;
        }
        throw new IllegalArgumentException();
    }

}
