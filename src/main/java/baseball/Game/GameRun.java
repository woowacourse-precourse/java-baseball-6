package baseball.Game;

public class GameRun {

    public static void gameStart() {

        boolean restart = true;

        while(restart) {

            System.out.println("숫자 야구 게임을 시작합니다.");
            Game game = new Game();
            game.showResult();
            restart = game.askRestart();
        }
    }
}
