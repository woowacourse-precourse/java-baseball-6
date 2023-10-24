package baseball.Game;

//전체적인 숫자야구 게임의 반복실행 class

public class GameRun {

    public static void gameStart() {

        boolean restart = true;

        while (restart) {

            System.out.println("숫자 야구 게임을 시작합니다.");
            Game game = new Game();
            game.showResult();
            restart = game.askRestart();
        }
    }
}
