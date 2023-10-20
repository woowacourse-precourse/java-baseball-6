package baseball;

public class GameController {
    //TODO
    // - run() 게임을 실행시키는 메소드
    // - retry() ?

    GameService gameService = new GameService();

    public void run(){
        gameService.startGame();
    }
}
