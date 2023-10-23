package baseball;

public class ExitController implements Controller {
    @Override
    public void service(final GameStatus gameStatus) {
        gameStatus.end();
    }
}
