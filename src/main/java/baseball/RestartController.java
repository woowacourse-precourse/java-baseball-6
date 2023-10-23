package baseball;

public class RestartController implements Controller {
    @Override
    public void service(final GameStatus gameStatus) {
        gameStatus.init();
    }
}
