package baseball;

import baseball.gameLogic.Comparing;
import baseball.gameLogic.Game;
import baseball.gameLogic.RandomNumber;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.close;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        Game game = new Game();

        //시작 안내문구 출력
        output.startGame();

        int gameStatus = 1;

        while(gameStatus == 1) {
            game.startGame();
            gameStatus = input.statusInput();
        }

        //프로그램 종료 안내 문구 출력
        output.endProgram();

    }
}
