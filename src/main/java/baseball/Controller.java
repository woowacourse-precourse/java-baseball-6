package baseball;

import baseball.Message.Constant.RequestMessage;
import baseball.Message.printSystemMessage;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    final int NUMBER_OF_DIGIT = 3;
    final int MINIMUM_NUMBER = 1;
    final int MAXIMUM_NUMBER = 9;
    final int RESTART_GAME = 1;
    final int END_GAME = 2;

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        Retry();
    }

    private void setGame() {
        gameService.setGame(MINIMUM_NUMBER, MAXIMUM_NUMBER, NUMBER_OF_DIGIT);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame() {
        printSystemMessage.printGameOverMessage();
    }


    private void Retry() throws IllegalArgumentException {
        System.out.println(RequestMessage.REQUEST_RETRY_MESSAGE);
        if (getInputNum() == RESTART_GAME) {
            run();
        }
    }

    private int getInputNum() throws IllegalArgumentException {
        int input = Integer.parseInt(Console.readLine());

        if (input == 0 || input > END_GAME) {
            throw new IllegalArgumentException();
        }
        return input;
    }


}
