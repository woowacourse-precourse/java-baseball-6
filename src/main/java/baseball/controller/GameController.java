package baseball.controller;

import baseball.model.GameModel;
import baseball.view.View;

public class GameController {
    private View view;
    private GameModel model;

    public GameController() {
        model = new GameModel();
        view = new View();
    }

    public void playGame(){
        view.printStart();
        while (!model.getGameEndFlag()){
            while (!model.getGuessEndFlag()) {
                String guess = view.getUserGuess();
                model.checkValidGuess(guess);
                view.printGuessResult(model.checkGuess());
            }
            view.printFinish();
            String checkContinue = view.getContinueGameInput();
            model.checkValidContinueInput(checkContinue);
            checkRestart(checkContinue);
        }
    }
    private void checkRestart(String checkContinue){
        if(checkContinue.equals("1")){
            model.setNewGame();
        }
        else if (checkContinue.equals("2")) {
            model.setGameEndFlag(true);
        }
    }

}
