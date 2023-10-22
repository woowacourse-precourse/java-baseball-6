package baseball;

import java.io.IOException;

public class Controller {

    private Game model;
    private GameView view;

    public Controller(Game model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void playGame() {
        view.startGame();
        model.computerNumberGeneration();
        while(true){
            String userNumber = view.getUserInput();
            model.setUserNumber(userNumber);
            model.setStrikes();
            model.setBalls();
            model.calculateResult();
            if(view.showResult(model)){
                if(!gameIsOVer()){
                    System.out.println("게임 종료");
                    break;
                }
                model.computerNumberGeneration();
            };
        }
    }

    public boolean gameIsOVer() {
        return view.playAgain();
    }

}
