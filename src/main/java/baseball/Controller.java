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

            // 유저 숫자 입력
            String userNumber = view.getUserInput();
            modifyModel(userNumber);

            // 유저와 컴퓨터 숫자 계산
            model.calculateResult();
            if(view.showResult(model)){
                if(!gameIsOVer()){
                    System.out.println("게임 종료");
                    break;
                }

                // 재시작 할 경우 컴퓨터 숫자 다시 생성
                model.computerNumberGeneration();
            };
        }
    }

    public boolean gameIsOVer() {
        return view.playAgain();
    }

    public void modifyModel(String userNumber){
        model.setUserNumber(userNumber);
        model.setStrikes();
        model.setBalls();
    }

}
