package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.gameStart();
        while(true){
            game.playGame();
            if(!game.keepGo()){
                break;
            }
        }

    }
}
