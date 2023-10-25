package baseball.game;

public class GameController {
    static final GameService gameService = new GameService();

    public GameController(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameStart(){
        gameService.execute();
    }





}
