package baseball.controller;

import baseball.model.BaseballGameModel;
import baseball.view.BaseballGameView;

import java.util.List;

public class BaseballGameController {
    private BaseballGameModel model;
    private BaseballGameView view;

    public BaseballGameController(BaseballGameModel model, BaseballGameView view){
        this.model = model;
        this.view = view;
    }

    public void startGame(){
        view.displayWelcomeMessage();
        while (true){
            playGame();
            if (!playAgain()){
                return;
            }
        }

    }
    public void playGame(){
        view.displayUserInputMessage();
        while (true){
            try {
                view.generateUserGuessNums();
                List<Integer> userGuessNums = view.getUserGuessNums();
                int[] guess = model.guess(userGuessNums);

                //3스트라이크
                if (guess[0]==3){
                    view.displayGameEndMessage();
                    break;
                }
                //3스트라이크는 아니지만 볼은 없고 스트라이크만 있는 경우
                if (guess[1]==0 && guess[0]>0){
                    view.displayOnlyStrikeResult(guess);
                }

                //스트라이크는 없고 볼만 있는 경우
                if (guess[1]>0 && guess[0]==0){
                    view.displayOnlyBallResult(guess);
                }

                //스트라이크 볼 둘다 있는 경우
                if (guess[1]>0 && guess[0]>0){
                    view.displayBothResult(guess);
                }

                if (guess[0]==0 && guess[1]==0){
                    view.displayNothingResult();
                }


            } catch (IllegalArgumentException e){
                return;
            }
        }

    }

    private boolean playAgain() {
        view.displayRestartOrQuitMessage();
        int userChoice = view.getPlayAgainChoice();

        return userChoice==1;
    }


}
