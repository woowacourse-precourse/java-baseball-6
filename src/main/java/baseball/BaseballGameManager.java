package baseball;

public class BaseballGameManager implements GameManager{

    @Override
    public void startGameProcess() {
        while(true) {
            // 최초 게임시작
            Game game = BaseballGame.createGame();
            game.startAnnounce();

            // 게임 한판을 진행한다.
            boolean replay = game.playGame();

            // 새 게임을 진행하거나 종료한다.
            if (!replay) {
                break;
            }
        }
    }

}
