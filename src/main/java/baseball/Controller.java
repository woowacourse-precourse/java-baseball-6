package baseball;

import baseball.service.GameService;
import baseball.view.Message;
import camp.nextstep.edu.missionutils.Console;
public class Controller {
    final int RETRY = 1;
    final int GAME_OVER = 2;

    int[] RandomNumber;
    public void run() throws IllegalArgumentException{
        RandomNumber = GameService.GameSettings();
        GameService.Play(RandomNumber);
        EndGame();
    }

    private void EndGame() throws IllegalArgumentException{
        Message.printGameOver();
        if (getInputRetry() == RETRY) {
            run();
        }
    }

    private int getInputRetry() throws IllegalArgumentException {
        int inputNum = Integer.parseInt(Console.readLine());
        if (inputNum > GAME_OVER || inputNum < 1) {
            throw new IllegalArgumentException();
        }
        return inputNum;
    }

}
