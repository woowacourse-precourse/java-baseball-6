package baseball;

public class BaseballGameManager implements GameManager{

    @Override
    public void startGameProcess() {
        Game game = new BaseballGame();

        // 최초 게임시작 멘트를 출력한다.
        game.startAnnounce();

        while(true) {
            // 게임 한판을 진행한다.
            boolean replay = game.playGame();

            // 새 게임을 진행하거나 종료한다.
            if (replay) {
                game = new BaseballGame();
            } else {
                break;
            }
        }
    }

}
