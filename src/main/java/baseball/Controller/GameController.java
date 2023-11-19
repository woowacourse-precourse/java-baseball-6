package baseball.Controller;

import baseball.Service.CheckUserNumber;
import baseball.Model.Game;
import baseball.View.GameView;

import java.util.List;

public class GameController {

    private final GameView gameView = new GameView();

    public GameController(){
        gameView.showGameStart();
    }

    public void GameStart(){
        Game game = new Game();
        while(game.gamestatus()){
            gameView.showInputNumbers();  //숫자를 입력해 주세요:
            String strInputNumbers = gameView.getInput(); //입력받아 string형에 저장
            CheckUserNumber check = new CheckUserNumber(strInputNumbers); //오류 검사
            List<Integer> UserNumbers = game.stringToIntList(strInputNumbers); //console로 입력 받으면 string형 이기 때문에 비교과 쉽게 List로 변환

            String Gameresult = game.makeGameResult(UserNumbers);
            gameView.showString(Gameresult);
        }
        gameView.showGameEnd();

        gameView.showInputRestart();
        String strInputRestart = gameView.getInput();
        if (game.isRestart(strInputRestart)) {
            GameStart();
        }
    }


}
