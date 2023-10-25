package baseball;


import baseball.controller.BaseballGame;
import baseball.model.RestartNum;
import baseball.view.Input;
import baseball.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output.printGameStart(); // 숫자 야구 게임을 시작합니다

        do {
            BaseballGame baseBallGame = new BaseballGame();
            baseBallGame.gameStart();
        } while (restart());

    }
    public static boolean restart (){
        RestartNum restartNum = new RestartNum(Input.gameRestart());

        return restartNum.getRestartNum().equals("1");
    }
}
