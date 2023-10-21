package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int restart;
        GameManager game = new GameManager();
        do {
            game.gameInit();
            restart = game.startGames();
        }while(restart==1);
    }
}
