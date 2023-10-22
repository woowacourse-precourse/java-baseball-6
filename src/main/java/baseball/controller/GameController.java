package baseball.controller;

import baseball.model.Models;
import baseball.view.Views;



import java.util.List;

public class GameController {


    public void startGame() {

        while (true) {
            Views.printIntro();

            List<Integer> answer = Models.generateNumber();
            boolean isPossible = true;
            while(isPossible) {
                Views.printQuestion();
                String userNumbers = Views.inputNumber();

                Models.validateInputSize(userNumbers);

                List<String> splitStringList = Models.splitStringToList(userNumbers);
                List<Integer> splitIntegerList = Models.convertStringToInteger(splitStringList);

                int strikeCount = 0;
                int ballCount = 0;

                for (int i = 0; i < Models.VALID_INPUT_LENGTH; i++) {
                    if(Models.checkMatchingDigits(i,answer,splitIntegerList)){
                        if(Models.isStrike(i,answer,splitIntegerList)){
                            strikeCount++;
                        }
                        else{
                            ballCount++;
                        }
                    }
                }
                if(strikeCount ==3 ){
                    Views.printStrike(strikeCount);
                    Views.printOut();
                    isPossible = false;
                }
                else if(Models.containsBothStrikeAndBall(strikeCount,ballCount)){
                    Views.printStrikeBallCount(strikeCount,ballCount);
                }
                else if (strikeCount >0){
                    Views.printStrike(strikeCount);
                } else if (ballCount > 0) {
                    Views.printBall(ballCount);
                }
                else {
                    Views.printNothing();
                }
            }

            if(reStrateGame()) {
                break;
            }

        }
    }

    private boolean reStrateGame() {
        Views.printWantRegame();
        String input = Views.inputNumber();
        Models.validateStringOneorTwo(input);
        if(!Models.askRestart(input)){
            return true;
        }
        return false;
    }
}
