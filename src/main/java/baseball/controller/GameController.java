package baseball.controller;

import baseball.model.Models;
import baseball.view.Views;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {


    public void startGame() {

        while (true) {
            Views.printIntro();

            List<Integer> answer = Models.generateNumber();

            while(true) {
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
                    break;
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

            Views.printWantRegame();
            String input = Views.inputNumber();
            Models.validateStringOneorTwo(input);
            if(!Models.askRestart(input)){
                break;
            }

        }




    }
}
